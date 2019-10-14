package br.com.jbrasileiro.peixeurbano.deal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.jbrasileiro.peixeurbano.AbstractTestIntegration;

public class DealEndpointIT
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;

	@Test
	public void readdAllEmpty()
		throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/deal/read/all")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("[]"));
	}

	@Test
	public void createDeal()
			throws Exception {
		String expected = read("IT/DEAL/create_minimal-expected.json");
		mvc.perform(MockMvcRequestBuilders.post("/deal/create")
			.contentType(MediaType.APPLICATION_JSON)
			.content(read("IT/DEAL/create_minimal.json")))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json(expected, true));
	}

	@Test
	public void readAll()
			throws Exception {
		String expected = read("IT/DEAL/create_batch-expected.json");
		mvc.perform(MockMvcRequestBuilders.post("/deal/create/batch")
			.contentType(MediaType.APPLICATION_JSON)
			.content(read("IT/DEAL/create_create_batch.json")))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().json(expected, true));

		String readExpected = read("IT/DEAL/readl-all-expected.json");
		mvc.perform(MockMvcRequestBuilders.get("/deal/read/all")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().json(readExpected, true));
	}
}
