package br.com.jbrasileiro.peixeurbano.deal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jbrasileiro.peixeurbano.deal.to.DealCreateTO;
import br.com.jbrasileiro.peixeurbano.deal.to.DealReadAllTO;

@RestController
@RequestMapping("/deal")
public class DealEndpoint {

	private final DealService service;

	@Autowired
	public DealEndpoint(
		final DealService service) {
		super();
		this.service = service;
	}

	@GetMapping(
		value = "/read/all")
	public Collection<DealReadAllTO> readAll() {
		return service.readAll();
	}

	@PostMapping(
		value = "/create")
	public Deal create(@RequestBody @Valid final DealCreateTO request) {
		return service.save(request);
	}

	@PostMapping(
		value = "/create/batch")
	public List<Deal> createBatch(@RequestBody @Valid final Collection<DealCreateTO> request) {
		List<Deal> result = new ArrayList<>();
		for (DealCreateTO to : request) {
			result.add(service.save(to));
		}
		return result;
	}

	@ExceptionHandler
    public ResponseEntity<String> handleException(final Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
