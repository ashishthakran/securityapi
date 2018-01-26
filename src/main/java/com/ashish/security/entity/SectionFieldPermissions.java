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
@Table(name = "sectionfieldpermission", schema = "ontrackcrm", uniqueConstraints = {
		/*
		 * @UniqueConstraint(name = "uk_appper_app_group", columnNames =
		 * {"applicationid", "groupid"}),
		 */
		@UniqueConstraint(name = "uk_secfieldper_app_role", columnNames = { "fieldid", "roleid" }) }, indexes = {
				/* @Index(columnList = "applicationid, groupid"), */
				@Index(columnList = "fieldid, roleid"), 
				@Index(columnList = "sectionid"),
				@Index(columnList = "fieldid"),
				/* @Index(columnList = "groupid"), */
				})
public class SectionFieldPermissions extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sectionid", nullable = false, updatable = false)
	private ModuleSections section;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fieldid", nullable = false, updatable = false)
	private SectionsFields sectionfield;

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

	public ModuleSections getSection() {
		return section;
	}

	public void setSection(ModuleSections section) {
		this.section = section;
	}

	public SectionsFields getSectionfield() {
		return sectionfield;
	}

	public void setSectionfield(SectionsFields sectionfield) {
		this.sectionfield = sectionfield;
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
		result = prime * result + ((sectionfield == null) ? 0 : sectionfield.getId().hashCode());
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
		SectionFieldPermissions other = (SectionFieldPermissions) obj;
		if (permissions == null) {
			if (other.permissions != null)
				return false;
		} else if (!permissions.equals(other.permissions))
			return false;
		if (sectionfield == null) {
			if (other.sectionfield != null)
				return false;
		} else if (!sectionfield.getId().equals(other.sectionfield.getId()))
			return false;
		return true;
	}
}
