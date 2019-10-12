package br.com.jbrasileiro.peixeurbano.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public final class CustomProperties {

	private final String environment;
	private final String value;

	public CustomProperties(
		@Value("${application-enviromnt}") final String environment,
		@Value("${application-value}") final String value) {
		super();
		this.environment = environment;
		this.value = value;
	}

	public String getEnvironment() {
		return environment;
	}

	public String getValue() {
		return value;
	}
}
