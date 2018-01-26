package com.ashish.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.ApplicationPermissions;

@Repository
public interface IApplicationPermissionsRepository extends JpaRepository<ApplicationPermissions, String> {

	@Query(value = "SELECT distinct app.id FROM  application app inner join applicationpermission ap ON app.id = ap.applicationid WHERE app.code = :code AND ap.roleid in :roles", nativeQuery = true)
	public Integer hasPermissions(@Param("code") String applicationCode, @Param("roles") List<String> roles);
}
