package br.com.bruno.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

@RunWith(MockitoJUnitRunner.class)
public class BibliaServiceTest {
	
	@InjectMocks
	private BibliaService bibliaService;
	
	@Before
	public void inicializar() {
		ReflectionTestUtils.setField(bibliaService, "url", "https://bibleapi.co/");
	}
	
	@Test
	public void deveriaDevolverAUrlCorretamente() {
		String url = bibliaService.getUrl();
		assertEquals("https://bibleapi.co/", url);
	}

}
