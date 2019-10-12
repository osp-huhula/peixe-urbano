package br.com.jbrasileiro.peixeurbano;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test-integration")
@RunWith(SpringRunner.class)
@ITAnnotation
public abstract class AbstractTestIntegration {

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	@Before
	public void setup() {
	}

	@After
	public void clean() {
	}

	@AfterClass
	public static void shutdown() {
	}

}
