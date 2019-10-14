package br.com.jbrasileiro.peixeurbano.commons;

import java.util.Date;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!time-frozen")
@Component
public class DateProviderDefault
	implements
	DateProvider {

	@Override
	public Date now() {
		return new Date();
	}
}
