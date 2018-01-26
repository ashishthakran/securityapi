package com.ashish.security.entity;

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
@Table(name = "applicationpermission", schema = "ontrackcrm", 
	uniqueConstraints = {
		  /*@UniqueConstraint(name = "uk_appper_app_group", columnNames = {"applicationid", "groupid"}),*/
		  @UniqueConstraint(name = "uk_appper_app_role", columnNames = {"applicationid", "roleid"})
	},
	indexes = {
			/*@Index(columnList = "applicationid, groupid"),*/
			@Index(columnList = "applicationid, roleid"),
			/*@Index(columnList = "groupid"),*/
			@Index(columnList = "roleid")
	}
)
public class ApplicationPermissions extends AbstractBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "applicationid", nullable = false, updatable = false)
	private Applications application;

	/*@NotNull
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "groupid", updatable = false)
	private Groups group;*/

	@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleid", updatable = false)
	private Roles role;

	public Applications getApplication() {
		return application;
	}

	public void setApplication(Applications application) {
		this.application = application;
	}

	/*public Groups getGroup() {
		return group;
	}

	public void setGroup(Groups group) {
		this.group = group;
	}*/

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((application == null) ? 0 : application.hashCode());
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
		ApplicationPermissions other = (ApplicationPermissions) obj;
		if (application == null) {
			if (other.application != null)
				return false;
		} else if (!application.equals(other.application))
			return false;
		return true;
	}
}
