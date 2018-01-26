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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "modulesection", schema = "ontrackcrm", uniqueConstraints = {
		@UniqueConstraint(name = "uk_sec_mod_name", 
		columnNames = { "moduleid", "name" }) 
		},
		indexes = {
				@Index(columnList = "moduleid")
		}
)
public class ModuleSections extends AuditableBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "moduleid", nullable = false, updatable = false)
	private ApplicationModules module;	

	@NotNull
	@Column(name = "name", length = 50, nullable = false)
	private String name;
	
	@Column(name = "description", length = 500)
	private String description;
	
	@NotNull
	@Column(name = "status", length = 10, nullable = false)
	private String status;
	
	@BatchSize(size = 32)
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<SectionFieldPermissions> fields;

	public ApplicationModules getModule() {
		return module;
	}

	public void setModule(ApplicationModules module) {
		this.module = module;
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

	public Set<SectionFieldPermissions> getFields() {
		return fields;
	}

	public void setFields(Set<SectionFieldPermissions> fields) {
		this.fields = fields;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		ModuleSections other = (ModuleSections) obj;
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
