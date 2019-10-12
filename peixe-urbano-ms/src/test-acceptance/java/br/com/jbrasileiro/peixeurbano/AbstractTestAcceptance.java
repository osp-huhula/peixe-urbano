package br.com.jbrasileiro.peixeurbano;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test-acceptance")
@RunWith(SpringRunner.class)
@ATAnnotation
public abstract class AbstractTestAcceptance {

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
