package com.ashish.security.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.ModuleSections;
import com.ashish.security.entity.Roles;
import com.ashish.security.entity.SectionFieldPermissions;

@Repository
public interface ISectionFieldPermissionsRepository extends JpaRepository<SectionFieldPermissions, String> {

	public Set<SectionFieldPermissions> findBySectionAndRoleIn(ModuleSections section, Set<Roles> roles);
}
