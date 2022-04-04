package br.com.bruno.controller;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

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

}
