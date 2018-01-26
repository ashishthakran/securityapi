package com.ashish.security.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "applicationmodule", schema = "ontrackcrm",
		indexes = {
				@Index(columnList = "applicationid")
		}
)
public class ApplicationModules extends AuditableBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "name", length = 50, unique = true, nullable = false)
	private String name;

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applicationid", nullable = false, updatable = false)
	private Applications application;	

	@Column(name = "description", length = 500)
	private String description;
	
	@Column(name = "url", length = 500)
	private String url;
	
	@NotNull
	@Column(name = "status", length = 10, nullable = false)
	private String status;
	
	//@BatchSize(size = 32)
	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<SectionPermissions> sections;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Applications getApplication() {
		return application;
	}

	public void setApplication(Applications application) {
		this.application = application;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<SectionPermissions> getSections() {
		return sections;
	}

	public void setSections(Set<SectionPermissions> sections) {
		this.sections = sections;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicationModules other = (ApplicationModules) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
}
