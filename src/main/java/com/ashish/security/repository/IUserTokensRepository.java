package com.ashish.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ashish.security.entity.UserTokens;

@Repository
public interface IUserTokensRepository extends JpaRepository<UserTokens, String> {

}
