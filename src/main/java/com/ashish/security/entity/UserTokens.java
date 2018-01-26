package com.ashish.security.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.ashish.security.entity.AuditableBaseEntity;

@Entity
@Table(name = "user_tokens", schema = "ontrackcrm", 
	indexes = {
			@Index(columnList = "token"),
			@Index(columnList = "userid")
	}		
)
public class UserTokens extends AuditableBaseEntity {

	private static final long serialVersionUID = 1L;

	/*@NotNull
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)*/
	@Column(name = "userid", nullable = false, updatable = false)
	private String userId;

	@Column(name = "type", length = 20)
	private String type;

	@Column(name = "token", length = 36, unique = true, nullable = false)
	private String token;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		UserTokens other = (UserTokens) obj;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}
