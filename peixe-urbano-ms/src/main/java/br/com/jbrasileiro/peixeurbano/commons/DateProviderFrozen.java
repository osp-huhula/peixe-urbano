package br.com.jbrasileiro.peixeurbano.commons;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("time-frozen")
@Component
public class DateProviderFrozen
	implements
	DateProvider {

	private static final LocalDateTime NOW = LocalDateTime.of(2000, 12, 30, 12, 59, 59);

	@Override
	public Date now() {
        Instant instant = NOW.toInstant(ZoneOffset.UTC);
        return Date.from(instant);
	}
}
