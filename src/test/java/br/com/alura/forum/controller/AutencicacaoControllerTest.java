package br.com.alura.forum.controller;

import java.net.URI;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class AutencicacaoControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void authenticationFailure() throws Exception {
		URI uri = new URI("/auth");
		JSONObject json = new JSONObject();
		json.put("email", "invalido@email.com");
		json.put("senha", "123456");
		System.out.println(json.toString());
		
		mockMvc.perform(MockMvcRequestBuilders
				.post(uri)
				.content(json.toString())
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect(MockMvcResultMatchers
				.status()
				.is(403));
		
		
	}

}
