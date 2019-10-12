package br.com.jbrasileiro.peixeurbano;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Value("${value}")
	private String value;
	@Value("${application-profile}")
	private String profile;

	@Test
	public void contextLoads() {
	}

	@Test
	public void value()
		throws Exception {
		Assert.assertEquals("production", value);
	}

	@Test
	public void profile()
		throws Exception {
		Assert.assertEquals("production", profile);
	}
}
