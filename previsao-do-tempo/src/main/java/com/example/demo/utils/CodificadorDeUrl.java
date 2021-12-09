package com.example.demo.utils;

import java.net.URISyntaxException;

import org.apache.http.client.utils.URIBuilder;

public class CodificadorDeUrl {

	public static String codificar(String texto) {

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

}
