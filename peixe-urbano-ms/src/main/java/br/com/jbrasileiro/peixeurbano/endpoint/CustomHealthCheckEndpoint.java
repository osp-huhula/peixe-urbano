package br.com.jbrasileiro.peixeurbano.endpoint;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomHealthCheckEndpoint {


	@Value("${application-profile}")
	private String phase;

	@GetMapping("health/custom/check")
	public ResponseEntity<String> healthCheck() {
		return ResponseEntity.ok("up");
	}

	@GetMapping("health/custom/check-phase")
	public ResponseEntity<String> healthCheckPhase() {
		return ResponseEntity.ok(phase);
	}
}
