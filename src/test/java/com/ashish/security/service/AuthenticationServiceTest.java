package com.ashish.security.service;

import static org.mockito.Mockito.when;

import java.security.NoSuchAlgorithmException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ashish.security.common.enums.Status;
import com.ashish.security.dto.LoginDto;
import com.ashish.security.repository.IUserRepository;
import com.ashish.security.repository.IUserTokensRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class AuthenticationServiceTest {

	@Mock
	private IUserRepository userRepository;
	
	@Mock
	private IUserTokensRepository userTokenRepository;

	@InjectMocks
	private AuthenticationService authenticationService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test(expected = BadCredentialsException.class)
	public void testIfInvalidUserPassword() throws NoSuchAlgorithmException {
		LoginDto loginDto = new LoginDto();
		authenticationService.authenticate(loginDto);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = UsernameNotFoundException.class)
	public void testIfUserEmailNotFound() throws NoSuchAlgorithmException {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("Ashish12@gmail.com");
		
		when(userRepository.findByEmailAndStatus(loginDto.getUsername(), Status.ACTIVE.getValue())).thenThrow(UsernameNotFoundException.class);		
		authenticationService.authenticate(loginDto);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = UsernameNotFoundException.class)
	public void testIfUserNotFound() throws NoSuchAlgorithmException {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("Ashish12");
		
		when(userRepository.findByUsernameAndStatus(loginDto.getUsername(), Status.ACTIVE.getValue())).thenThrow(UsernameNotFoundException.class);		
		authenticationService.authenticate(loginDto);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = BadCredentialsException.class)
	public void testIfUserPasswordMismatch() throws NoSuchAlgorithmException {
		LoginDto loginDto = new LoginDto();
		loginDto.setUsername("ashish");
		loginDto.setPassword("123454");
		
		when(userRepository.findByUsernameAndStatus(loginDto.getUsername(), Status.ACTIVE.getValue())).thenThrow(BadCredentialsException.class);		
		authenticationService.authenticate(loginDto);
	}
}
