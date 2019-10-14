package br.com.jbrasileiro.peixeurbano.commons;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GenericGlobalExceptionHandler
	extends
	ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(
		final Exception ex,
		final Object body,
		final HttpHeaders headers,
		final HttpStatus status,
		final WebRequest request) {
		ex.printStackTrace();
		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
}
