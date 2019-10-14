package br.com.jbrasileiro.peixeurbano.deal;

import java.text.Normalizer;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jbrasileiro.peixeurbano.commons.DateProvider;
import br.com.jbrasileiro.peixeurbano.deal.to.DealCreateTO;
import br.com.jbrasileiro.peixeurbano.deal.to.DealReadAllTO;

@Service
public final class DealService {

	private static final Pattern NONLATIN = Pattern.compile("[^\\w-]");
	private static final Pattern WHITESPACE = Pattern.compile("[\\s]");
	private static final Pattern EDGESDHASHES = Pattern.compile("(^-|-$)");
	private final DealRepository repository;
	private final DateProvider dateProvider;

	@Autowired
	public DealService(
		final DealRepository repository,
		final DateProvider dateProvider) {
		super();
		this.repository = repository;
		this.dateProvider = dateProvider;
	}

	public Collection<DealReadAllTO> readAll() {
		return repository.readAll();
	}

	public Deal save(
		final DealCreateTO to) {
		Deal entity = convertTo(to);
		return repository.save(entity);
	}

	private Deal convertTo(
		final DealCreateTO value) {
		Deal result = new Deal();
		result.setTitle(value.getTitle());
		result.setText(value.getText());
		Date created = value.getCreateDate();
		if (Objects.nonNull(created)) {
			result.setCreateDate(created);
		} else {
			result.setCreateDate(dateProvider.now());
		}
		result.setPublicDate(requitedDate(value.getPublicDate()));
		result.setEndDate(requitedDate(value.getEndDate()));
		result.setUrl(toSlug(value.getTitle()));
		result.setType(value.getType());
		return result;
	}

	private String toSlug(final String input) {
	    String nowhitespace = WHITESPACE.matcher(input).replaceAll("-");
	    String normalized = Normalizer.normalize(nowhitespace, Normalizer.Form.NFD);
	    String slug = NONLATIN.matcher(normalized).replaceAll("");
	    slug = EDGESDHASHES.matcher(slug).replaceAll("");
	    return slug.toLowerCase(Locale.ENGLISH);
	}

	private Date requitedDate(
		final Date date) {
		return Optional.ofNullable(date).orElseThrow(() -> new IllegalArgumentException("Date is required"));
	}
}
