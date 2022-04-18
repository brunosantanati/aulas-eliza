package br.com.bruno.controller;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MatematicaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveSomarDoisNumerosAleatoriosComSucesso() throws Exception {
		URI uri = new URI("/somar");
		
		mockMvc
			.perform(get(uri))
			.andExpect(status().is(200))
			.andExpect(content().string(containsString("{\"resultado\":")));
	}
	
	@Test
	public void deveSomarDoisNumerosComSucesso() throws Exception {
		mockMvc
			.perform(get("/somar/{n1}/{n2}", "10.0", "20.0").contentType("application/json"))
			.andExpect(status().is(200))
			.andExpect(jsonPath("$.resultado", is(30.0d))) //essa linha e as de baixo fazem a mesma coisa, só deixei todas para ter um exemplo de cada
			.andExpect(jsonPath("$.resultado").value(30.0d))
			.andExpect(content().json("{'resultado': 30.0}"))
			.andExpect(content().json("{\"resultado\": 30.0}"));
	}

}
