package br.com.jbrasileiro.peixeurbano.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.com.jbrasileiro.peixeurbano.AbstractTestIntegration;
import br.com.jbrasileiro.peixeurbano.commons.CustomProperties;

public class CustomHealthCheckEndpointIT
	extends
	AbstractTestIntegration {

	@Autowired
	private MockMvc mvc;
	@Autowired
	private CustomProperties properties;

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
		Assert.assertEquals("integration-test", properties.getValue());
	}

	@Test
	public void environment()
			throws Exception {
		Assert.assertEquals("integration-test", properties.getEnvironment());
	}
}
