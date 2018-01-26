package com.ashish.security.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "application", schema = "ontrackcrm",
		indexes = {
				@Index(columnList = "code")
		}
)
public class Applications extends AuditableBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "code", length = 30, unique = true, nullable = false)
	private String code;

	@NotNull
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "description", length = 500)
	private String description;
	
	@NotNull
	@Column(name = "status", length = 10)
	private String status;

	//@BatchSize(size = 16)
	@OneToMany(mappedBy = "application", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ModulePermissions> modules;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<ModulePermissions> getModules() {
		return modules;
	}

	public void setModules(Set<ModulePermissions> modules) {
		this.modules = modules;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Applications other = (Applications) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
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
		return true;
	}
}
