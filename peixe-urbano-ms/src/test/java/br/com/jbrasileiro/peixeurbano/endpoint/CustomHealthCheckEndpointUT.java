package br.com.jbrasileiro.peixeurbano.endpoint;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:properties/test-unit.properties")
public class CustomHealthCheckEndpointUT {

	@Value("${value}")
	private String value;
	@Value("${application-profile}")
	private String profile;

	@Test
	public void value()
		throws Exception {
		Assert.assertEquals("unit-test", value);
	}

	@Test
	public void profile()
			throws Exception {
		Assert.assertEquals("unit-test", profile);
	}
}
