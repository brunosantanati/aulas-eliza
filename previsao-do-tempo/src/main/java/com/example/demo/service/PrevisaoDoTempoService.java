package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

import com.example.demo.dto.GeolocalizacaoDados;
import com.example.demo.dto.HttpRequestDados;
import com.example.demo.dto.HttpResponseDados;
import com.example.demo.dto.PrevisaoDoTempoDados;
import com.example.demo.dto.PrevisaoDoTempo;

@Service
public class PrevisaoDoTempoService {
	
	@Autowired
	@Qualifier("geolocalizacao")
	HttpRequestService httpRequestGeolocalizacaoService;
	
	@Autowired
	@Qualifier("previsaoDoTempo")
	HttpRequestService httpRequestPrevisaoDoTempoService;
	
	public PrevisaoDoTempo getPrevisaoDoTempo(String endereco){
		
		GeolocalizacaoDados geolocalizacaoDados = consumirApiDeGeolocalizacao(endereco);
		String localizacao = geolocalizacaoDados.getFeatures().get(0).getPlace_name();
		
		PrevisaoDoTempoDados previsaoDoTempoDados = consumirApiPrevisaoDoTempo(geolocalizacaoDados);
		String resumo = previsaoDoTempoDados.getDaily().getData().get(0).getSummary();
		float humidade = previsaoDoTempoDados.getDaily().getData().get(0).getHumidity();
		float temperaturaAtual = previsaoDoTempoDados.getCurrently().getTemperature();
		float chancesDeChover = previsaoDoTempoDados.getCurrently().getPrecipProbability();
		
		PrevisaoDoTempo PrevisaoDoTempo = new PrevisaoDoTempo();
		PrevisaoDoTempo.setResumo(resumo);
		PrevisaoDoTempo.setTemperaturaAtual("Temperatura Atual: " + temperaturaAtual);
		PrevisaoDoTempo.setChancesDeChover("Existe " + chancesDeChover + " chances de chover");
		PrevisaoDoTempo.setHumidade("Humidade: " + humidade);
		PrevisaoDoTempo.setLocalizacao(localizacao);
		PrevisaoDoTempo.setEndereco(endereco);
		
		return PrevisaoDoTempo;		
	}
	
	private GeolocalizacaoDados consumirApiDeGeolocalizacao(String endereco) {
		String urlServicoGeolocalizacao = "https://api.mapbox.com/geocoding/v5/mapbox.places/" + codificarTexto(endereco) + ".json?access_token=pk.eyJ1IjoiYnJ1bm9zYW50YW5hdGkiLCJhIjoiY2s4ODFmMHB4MDBkeDNnbXNxOHhqYjBjaiJ9.mj3Dg_SMDKGbiOJ2oyT4Cw&limit=1";
		
		HttpResponseDados dadosRespostaGeo = httpRequestGeolocalizacaoService.executarRequest(urlServicoGeolocalizacao, new HttpRequestDados());
		
		GeolocalizacaoDados geolocalizacaoDados = (GeolocalizacaoDados) dadosRespostaGeo.getItem("geolocalizacaoDados");
		
		return geolocalizacaoDados;
	}
	
	private String codificarTexto(String texto) {
		
		try {
			
			String textoCodificado = new URIBuilder()
					  .setParameter("i", texto)
					  .build()
					  .getRawQuery()
					  .substring(2);
			
			return textoCodificado;
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return texto;
	}
	
	private PrevisaoDoTempoDados consumirApiPrevisaoDoTempo(GeolocalizacaoDados geolocalizacaoDados) {
		
		Float latitude = geolocalizacaoDados.getFeatures().get(0).getCenter().get(1);
		Float longitude = geolocalizacaoDados.getFeatures().get(0).getCenter().get(0);
		
		String urlServicoPrevisaoDoTempo = "https://api.darksky.net/forecast/70ff7c58595674b62c6cb99468310588/" + latitude + "," + longitude + "?units=si&lang=pt";
		
		HttpResponseDados dadosRespostaPrevisao = httpRequestPrevisaoDoTempoService.executarRequest(urlServicoPrevisaoDoTempo, new HttpRequestDados());
		
		PrevisaoDoTempoDados previsaoDoTempoDados = (PrevisaoDoTempoDados) dadosRespostaPrevisao.getItem("previsaoDoTempoDados");
		
		return previsaoDoTempoDados;
	}

}
