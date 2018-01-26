package com.ashish.security.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.ApplicationModules;
import com.ashish.security.entity.Roles;
import com.ashish.security.entity.SectionPermissions;

@Repository
public interface ISectionPermissionsRepository extends JpaRepository<SectionPermissions, String> {

	public Set<SectionPermissions> findByModuleAndRoleIn(ApplicationModules module, Set<Roles> roles);
}
