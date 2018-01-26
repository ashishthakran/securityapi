package com.ashish.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.SectionsFields;

@Repository
public interface ISectionFieldsRepository extends JpaRepository<SectionsFields, String> {

}
