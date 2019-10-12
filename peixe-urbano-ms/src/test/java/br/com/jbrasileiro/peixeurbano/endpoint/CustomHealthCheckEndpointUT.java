package br.com.jbrasileiro.peixeurbano.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jbrasileiro.peixeurbano.commons.CustomProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(
	locations = "classpath:properties/test-unit.properties")
public class CustomHealthCheckEndpointUT {

	@Autowired
	private CustomProperties properties;

	@Test
	public void value()
		throws Exception {
		Assert.assertEquals("unit-test", properties.getValue());
	}

	@Test
	public void environment()
		throws Exception {
		Assert.assertEquals("unit-test", properties.getEnvironment());
	}
}
