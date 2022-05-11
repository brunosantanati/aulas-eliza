package br.com.bruno.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BibliaService {
	
	@Value("${url.api.biblia}")
	private String url;
	
	public String getUrl() {
		return url;
	}

}
