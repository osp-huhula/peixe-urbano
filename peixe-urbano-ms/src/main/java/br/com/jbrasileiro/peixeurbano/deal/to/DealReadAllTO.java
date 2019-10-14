package br.com.jbrasileiro.peixeurbano.deal.to;

import java.io.Serializable;

public final class DealReadAllTO
	implements
	Serializable {

	private Long id;
	private String title;

	public DealReadAllTO(
		final Long id,
		final String title) {
		super();
		this.id = id;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(
		final Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(
		final String title) {
		this.title = title;
	}
}
