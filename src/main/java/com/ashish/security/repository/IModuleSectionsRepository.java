package com.ashish.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.ModuleSections;

@Repository
public interface IModuleSectionsRepository extends JpaRepository<ModuleSections, String> {

}
