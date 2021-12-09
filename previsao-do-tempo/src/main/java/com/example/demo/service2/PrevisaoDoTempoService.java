package com.example.demo.service2;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.GeolocalizacaoDados;
import com.example.demo.dto.PrevisaoDoTempo;
import com.example.demo.dto.PrevisaoDoTempoDados;
import com.example.demo.utils.CodificadorDeUrl;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service("PrevisaoDoTempoService2")
public class PrevisaoDoTempoService {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	public PrevisaoDoTempo getPrevisaoDoTempo(String endereco) {
		
		try {
			
			GeolocalizacaoDados geolocalizacaoDados = consumirApiDeGeolocalizacao(endereco);
			PrevisaoDoTempoDados previsaoDoTempoDados = consumirApiPrevisaoDoTempo(geolocalizacaoDados);
			
			String resumo = previsaoDoTempoDados.getDaily().getData().get(0).getSummary();
			String temperaturaAtual = "Temperatura Atual: " + previsaoDoTempoDados.getCurrently().getTemperature();
			String chancesDeChover = "Existe " + previsaoDoTempoDados.getCurrently().getPrecipProbability() + " chances de chover";
			String humidade = "Humidade: " + previsaoDoTempoDados.getDaily().getData().get(0).getHumidity();
			String localizacao = geolocalizacaoDados.getFeatures().get(0).getPlace_name();
			
			return new PrevisaoDoTempo(resumo, temperaturaAtual, chancesDeChover, humidade, localizacao, endereco);
			
		}catch(Exception e) {
			throw new RuntimeException("Ocorreu um erro ao gerar previsão do tempo.");
		}
	}
	
	private GeolocalizacaoDados consumirApiDeGeolocalizacao(String endereco) throws IOException, InterruptedException {
		
		String urlServicoGeolocalizacao = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + CodificadorDeUrl.codificar(endereco) + ".json?access_token=pk.eyJ1IjoiYnJ1bm9zYW50YW5hdGkiLCJhIjoiY2s4ODFmMHB4MDBkeDNnbXNxOHhqYjBjaiJ9.mj3Dg_SMDKGbiOJ2oyT4Cw&limit=1";
		
		HttpResponse<String> response = fazerChamadaHttp(urlServicoGeolocalizacao);

        return objectMapper.readValue(response.body(), GeolocalizacaoDados.class);

	}
	
	private PrevisaoDoTempoDados consumirApiPrevisaoDoTempo(GeolocalizacaoDados geolocalizacaoDados) throws IOException, InterruptedException {
		
		Float latitude = geolocalizacaoDados.getFeatures().get(0).getCenter().get(1);
		Float longitude = geolocalizacaoDados.getFeatures().get(0).getCenter().get(0);
		
		String urlServicoPrevisaoDoTempo = "https://api.darksky.net/forecast/70ff7c58595674b62c6cb99468310588/" + latitude + "," + longitude + "?units=si&lang=pt";
		
		HttpResponse<String> response = fazerChamadaHttp(urlServicoPrevisaoDoTempo);

        return objectMapper.readValue(response.body(), PrevisaoDoTempoDados.class);
	}

	private HttpResponse<String> fazerChamadaHttp(String url)
			throws IOException, InterruptedException {
		
		HttpClient client = HttpClient.newHttpClient();
		
        HttpRequest request = HttpRequest.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .uri(URI.create(url))
                .headers("Accept-Enconding", "gzip, deflate")
                .build();
        
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        
        if(response.statusCode() != HttpStatus.OK.value()) {
        	throw new RuntimeException("Ocorreu um erro ao realizar requisição HTTP.");
        }
        
		return response;
	}

}
