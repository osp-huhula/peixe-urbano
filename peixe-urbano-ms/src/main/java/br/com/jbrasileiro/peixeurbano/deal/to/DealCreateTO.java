package br.com.jbrasileiro.peixeurbano.deal.to;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import br.com.jbrasileiro.peixeurbano.deal.DealType;

public final class DealCreateTO
	implements
	Serializable {

	@NotEmpty(
		message = "Title cannot be null")
	private String title;
	@NotEmpty(
		message = "Text cannot be null")
	private String text;
	private Date createDate;
	@NotNull(
		message = "Public date cannot be null")
	private Date publicDate;
	@NotNull(
		message = "End date cannot be null")
	private Date endDate;
	@NotNull(
		message = "Type cannot be null")
	private DealType type;

	public String getTitle() {
		return title;
	}

	public void setTitle(
		final String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(
		final String text) {
		this.text = text;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(
		final Date createDate) {
		this.createDate = createDate;
	}

	public Date getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(
		final Date publicDate) {
		this.publicDate = publicDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(
		final Date endDate) {
		this.endDate = endDate;
	}

	public DealType getType() {
		return type;
	}

	public void setType(
		final DealType type) {
		this.type = type;
	}

	@Override
	public boolean equals(
		final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof DealCreateTO) {
			DealCreateTO o = (DealCreateTO) obj;
			return EqualsBuilder.reflectionEquals(this, o, true);
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
