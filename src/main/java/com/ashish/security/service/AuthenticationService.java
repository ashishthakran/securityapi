package com.ashish.security.service;

import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ashish.security.common.enums.Status;
import com.ashish.security.configurations.CustomApplicationProperties;
import com.ashish.security.dto.LoginDto;
import com.ashish.security.entity.UserTokens;
import com.ashish.security.entity.Users;
import com.ashish.security.repository.IUserRepository;
import com.ashish.security.repository.IUserTokensRepository;

@Service
public class AuthenticationService {

	@Autowired
	private IUserRepository userRepository;
	
	@Autowired	
	private IUserTokensRepository userTokenRepository;

	@Autowired
	private CustomApplicationProperties applicationProperties;

	public void authenticate(LoginDto loginDto) throws NoSuchAlgorithmException {
		if (StringUtils.stripToEmpty(loginDto.getUsername()).isEmpty()) {
			throw new BadCredentialsException("Invalid username and password");
		}

		Users user = getUserDetails(loginDto.getUsername());

		if (null == user) {
			throw new UsernameNotFoundException("User not found");
		}

		if (loginDto.getUsername().indexOf("@") == -1) {
			/*String encodedPassword = AppUtils.encodePassword(loginDto.getPassword(),
					applicationProperties.getPasswordEncodingMultiplication());*/
			
			if (!user.getPassword().equals(loginDto.getPassword())) {
				throw new BadCredentialsException("Invalid username and password");
			}	
		}
	}
	
	private Users getUserDetails(String username) {
		Users user = null;
		if (username.indexOf("@") != -1) {
			user = userRepository.findByEmailAndStatus(username.toLowerCase(), Status.ACTIVE.getValue());
		} else {
			user = userRepository.findByUsernameAndStatus(username.toLowerCase(), Status.ACTIVE.getValue());
		}
		return user;
	}
	public void isValidUser(String username) {
		Users user = getUserDetails(username);
		if (null == user) {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	public void isValidUser(Users user) {
		if (null == user) {
			throw new UsernameNotFoundException("User not found");
		}
	}
	
	public void forgotPassword(String username) {
		Users user = getUserDetails(username);
		isValidUser(user);		
		
		UserTokens userToken = new UserTokens();
		userToken.setCreatedBy("dbo");
		userToken.setModifiedBy("dbo");
		userToken.setToken(UUID.randomUUID().toString());
		userToken.setType("FORGOT_PASSWORD");
		userToken.setUserId(user.getId());
		userTokenRepository.save(userToken);
	}
}
