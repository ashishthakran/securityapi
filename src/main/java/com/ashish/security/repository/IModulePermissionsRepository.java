package com.ashish.security.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.Applications;
import com.ashish.security.entity.ModulePermissions;
import com.ashish.security.entity.Roles;

@Repository
public interface IModulePermissionsRepository extends JpaRepository<ModulePermissions, String> {

	public Set<ModulePermissions> findByApplicationAndRoleIn(Applications application, Set<Roles> roles);
}
