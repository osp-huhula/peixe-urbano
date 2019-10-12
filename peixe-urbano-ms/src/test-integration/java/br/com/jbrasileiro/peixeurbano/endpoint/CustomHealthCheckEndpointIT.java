package br.com.jbrasileiro.peixeurbano.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.jbrasileiro.peixeurbano.AbstractTestIntegration;

public class CustomHealthCheckEndpointIT
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;
	@Value("${value}")
	private String value;
	@Value("${application-profile}")
	private String profile;

	@Test
	public void check()
		throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/health/custom/check")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(MockMvcResultMatchers.status().isOk())
			.andExpect(MockMvcResultMatchers.content().string("up"));
	}

	@Test
	public void value()
		throws Exception {
		Assert.assertEquals("integration-test", value);
	}

	@Test
	public void profile()
			throws Exception {
		Assert.assertEquals("integration-test", profile);
	}
}
