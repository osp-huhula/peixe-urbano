package br.com.jbrasileiro.peixeurbano;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.jbrasileiro.peixeurbano.commons.io.ResourceReader;

@ActiveProfiles(profiles = {"test-integration", "time-frozen"} )
@RunWith(SpringRunner.class)
@ITAnnotation
public abstract class AbstractTestIntegration {

	protected ResourceReader reader() {
		return new ResourceReader();
	}

	@BeforeClass
	public static void beforeClass() {
	}

	@Before
	public void before() {
	}

	@After
	public void after() {
	}

	@AfterClass
	public static void afterClass() {
	}

	protected String read(
		final String fileName) {
		return reader().read(fileName);
	}

}
