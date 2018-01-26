package com.ashish.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "groups", schema = "ontrackcrm")
public class Groups extends AuditableBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "description", length = 500)
	private String description;
	
	@NotNull
	@Column(name = "status", length = 10)
	private String status;

	/*@ManyToMany(mappedBy = "groups")
	private Set<Users> users;
	
	@ManyToMany(mappedBy = "groups")
	private Set<Roles> roles;*/
	
	/*@OneToMany(mappedBy = "group", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<ApplicationPermissions> permissions;*/
	
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

	/*public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}*/

	/*public Set<ApplicationPermissions> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<ApplicationPermissions> permissions) {
		this.permissions = permissions;
	}*/

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
		Groups other = (Groups) obj;
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
