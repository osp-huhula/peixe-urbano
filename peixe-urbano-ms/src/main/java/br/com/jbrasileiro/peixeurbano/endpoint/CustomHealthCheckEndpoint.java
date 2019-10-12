package br.com.jbrasileiro.peixeurbano.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbrasileiro.peixeurbano.commons.CustomProperties;

@RestController
public class CustomHealthCheckEndpoint {

	private final CustomProperties properties;

	@Autowired
	public CustomHealthCheckEndpoint(
		final CustomProperties properties) {
		super();
		this.properties = properties;
	}

	@GetMapping("health/custom/check")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("up");
	}

	@GetMapping("health/custom/check-environment")
	public ResponseEntity<String> healthCheckPhase() {
		return ResponseEntity.ok(properties.getEnvironment());
	}
}
