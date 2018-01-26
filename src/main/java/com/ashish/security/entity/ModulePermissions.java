package com.ashish.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "modulepermission", schema = "ontrackcrm", uniqueConstraints = {
		/*
		 * @UniqueConstraint(name = "uk_appper_app_group", columnNames =
		 * {"applicationid", "groupid"}),
		 */
		@UniqueConstraint(name = "uk_modper_app_role", columnNames = { "moduleid", "roleid" }) }, indexes = {
				/* @Index(columnList = "applicationid, groupid"), */
				@Index(columnList = "moduleid, roleid"), 
				@Index(columnList = "applicationid"),
				/* @Index(columnList = "groupid"), */
				@Index(columnList = "roleid") })
public class ModulePermissions extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	/*@Column(name = "applicationid", length = 36)
	private Long applicationId;*/
	
	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applicationid", nullable = false, updatable = false)
	private Applications application;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "moduleid", nullable = false, updatable = false)
	private ApplicationModules module;

	/*
	 * @NotNull
	 * 
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "groupid", updatable = false) private Groups group;
	 */

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roleid", updatable = false)
	private Roles role;

	@Column(name = "permissions", length = 30)
	private String permissions;

	public Applications getApplication() {
		return application;
	}

	public void setApplication(Applications application) {
		this.application = application;
	}

	public ApplicationModules getModule() {
		return module;
	}

	public void setModule(ApplicationModules module) {
		this.module = module;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	public String getPermissions() {
		return permissions;
	}

	public void setPermissions(String permissions) {
		this.permissions = permissions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((application == null) ? 0 : application.getId().hashCode());
		result = prime * result + ((module == null) ? 0 : module.hashCode());
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ModulePermissions other = (ModulePermissions) obj;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.getId().equals(other.application.getId()))
			return false;
		if (module == null) {
			if (other.module != null)
				return false;
		} else if (!module.equals(other.module))
			return false;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		return true;
	}
}
