package com.ashish.security.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ashish.security.entity.AuditableBaseEntity;

@Entity
@Table(name = "users", schema = "ontrackcrm", 
	indexes = {
			@Index(columnList = "username"),
			@Index(columnList = "email")
	}		
)
public class Users extends AuditableBaseEntity {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Column(name = "username", length = 50, nullable = false)
	private String username;
	
	@NotNull
	@Column(name = "password", length = 200, nullable = false)
	private String password;

	@NotNull
	@Column(name = "firstname", length = 50)
	private String firstname;

	@Column(name = "middlename", length = 50)
	private String middlename;

	@NotNull
	@Column(name = "lastname", length = 50)
	private String lastname;

	@NotNull
	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "department", length = 50)
	private String department;

	@Column(name = "mobilephone", length = 15)
	private String mobilePhone;

	@Column(name = "officephone", length = 15)
	private String officePhone;

	@Column(name = "homephone", length = 15)
	private String homePhone;

	@Column(name = "signature", length = 100)
	private String signature;

	@NotNull
	@Column(name = "status", length = 10)
	private String status;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
		name = "userroles", 
		joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"), 
		schema = "ontrackcrm",
		uniqueConstraints = @UniqueConstraint(columnNames = {"userid", "roleid"}),
		indexes = @Index(columnList = "userid, roleid")
	)
	private Set<Roles> roles;
	
	/*@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(
		name = "usergroups", 
		joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "groupid", referencedColumnName = "id"), 
		schema = "ontrackcrm",
		uniqueConstraints = @UniqueConstraint(columnNames = {"userid", "groupid"}),
		indexes = @Index(columnList = "userid, groupid")
	)	
	private Set<Groups> groups;*/

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	/*public Set<Groups> getGroups() {
		return groups;
	}

	public void setGroups(Set<Groups> groups) {
		this.groups = groups;
	}*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((middlename == null) ? 0 : middlename.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((officePhone == null) ? 0 : officePhone.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((signature == null) ? 0 : signature.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Users other = (Users) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (middlename == null) {
			if (other.middlename != null)
				return false;
		} else if (!middlename.equals(other.middlename))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (officePhone == null) {
			if (other.officePhone != null)
				return false;
		} else if (!officePhone.equals(other.officePhone))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (signature == null) {
			if (other.signature != null)
				return false;
		} else if (!signature.equals(other.signature))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
