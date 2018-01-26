package com.ashish.security.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

public class AppUtils {

    public static RestTemplate getRestTemplateWithMessageConverter() {
        RestTemplate restTemplate = new RestTemplate();
        setMessageConverters(restTemplate);
        return restTemplate;
    }
    
    public static void addRestTemplateMessageConverter(RestTemplate restTemplate) {
        setMessageConverters(restTemplate);
    }

    public static void setMessageConverters(RestTemplate restTemplate) {
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    }
    
    public static String encodePassword(String password, short encodingMultipility) throws NoSuchAlgorithmException {
    	StringBuilder sb = new StringBuilder(password);
    	SecureRandom random = SecureRandom.getInstanceStrong();
		byte[] values = new byte[20];
		random.nextBytes(values);
		PasswordEncoder encoder = new BCryptPasswordEncoder(7, random);
		for(short i = 0; i < encodingMultipility; i++) {
			sb = new StringBuilder(encoder.encode(sb.toString()));
		}
		return sb.toString();
    }
    
/*    public static void main(String[] args) throws NoSuchAlgorithmException {
    	Date startDate = new Date();
    	System.out.println(encodePassword("abc", (short) 5));
    	Date endDate = new Date();
    	
    	System.out.println("Total Time => " + (endDate.getTime() - startDate.getTime()) + " sec ");
    }*/
}
