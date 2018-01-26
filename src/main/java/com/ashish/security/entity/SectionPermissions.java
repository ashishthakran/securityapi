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
import com.ashish.security.entity.AbstractBaseEntity;

@Entity
@Table(name = "sectionpermission", schema = "ontrackcrm", uniqueConstraints = {
		/*
		 * @UniqueConstraint(name = "uk_appper_app_group", columnNames =
		 * {"applicationid", "groupid"}),
		 */
		@UniqueConstraint(name = "uk_secper_app_role", columnNames = { "sectionid", "roleid" }) }, indexes = {
				/* @Index(columnList = "applicationid, groupid"), */
				@Index(columnList = "sectionid, roleid"),
				@Index(columnList = "moduleid"),
				/* @Index(columnList = "groupid"), */
				})
public class SectionPermissions extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "moduleid", nullable = false, updatable = false)
	private ApplicationModules module;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "sectionid", nullable = false, updatable = false)
	private ModuleSections section;

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

	public ApplicationModules getModule() {
		return module;
	}

	public void setModule(ApplicationModules module) {
		this.module = module;
	}

	public ModuleSections getSection() {
		return section;
	}

	public void setSection(ModuleSections section) {
		this.section = section;
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
		result = prime * result + ((permissions == null) ? 0 : permissions.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((section == null) ? 0 : section.getId().hashCode());
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
		SectionPermissions other = (SectionPermissions) obj;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.getId().equals(other.section.getId()))
			return false;
		return true;
	}
}
