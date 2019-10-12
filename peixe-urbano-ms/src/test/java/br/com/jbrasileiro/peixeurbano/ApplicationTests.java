package br.com.jbrasileiro.peixeurbano;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jbrasileiro.peixeurbano.commons.CustomProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("H2")
public class ApplicationTests {

	@Autowired
	private CustomProperties properties;

	@Test
	public void contextLoads() {
		// testing application context
	}

	@Test
	public void value()
		throws Exception {
		Assert.assertEquals("production", properties.getEnvironment());
	}

	@Test
	public void profile()
		throws Exception {
		Assert.assertEquals("production", properties.getValue());
	}
}
