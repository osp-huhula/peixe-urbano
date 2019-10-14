package br.com.jbrasileiro.peixeurbano.deal;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Entity
@Table(
	name = "DEAL")
public final class Deal {

	@Id
	@GeneratedValue(
		strategy = GenerationType.IDENTITY)
	public Long id;
	@Column(
		nullable = false)
	private String title;
	@Column(
		nullable = false)
	private String text;
	@Column(
		nullable = false)
	private Date createDate;
	@Column(
		nullable = false)
	private Date publicDate;
	@Column(
		nullable = false)
	private Date endDate;
	@Column(
		unique = true,
		nullable = false)
	private String url;
	@Column
	private Long totalSold;
	@Column(
		nullable = false)
	private DealType type;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(
		final String url) {
		this.url = url;
	}

	public Long getTotalSold() {
		return totalSold;
	}

	public void setTotalSold(
		final Long totalSold) {
		this.totalSold = totalSold;
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
		if (obj instanceof Deal) {
			Deal o = (Deal) obj;
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
