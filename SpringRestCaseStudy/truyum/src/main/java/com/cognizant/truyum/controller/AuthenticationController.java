package com.cognizant.truyum.controller;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {
	final static Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);
	
	@GetMapping("/authenticate")
	public Map<String, String>  authenticate(@RequestHeader("Authorization") String authHeader) {
		Map<String, String> map = new HashMap<String, String>();
		
		LOGGER.info("START");
		
		LOGGER.debug(authHeader);
		String user = getUser(authHeader);
		LOGGER.debug("Decrypted : "+user);
		LOGGER.debug("User based Token generation : "+generateJwt(user));
		LOGGER.info("END");
		map.put("token",generateJwt(user));//generateJwt(user)
		return map;
	}
	
	private static String getUser(String authHeader) {
		LOGGER.info("START");
		String[] authHeaders =  authHeader.split(" ");
		String str = new String(Base64.getDecoder().decode(authHeaders[1]));
		LOGGER.debug(str.split(":")[0]);
		LOGGER.info("END");
		return str.split(":")[0];
	}
	
	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		// Set the token issue time as current time
		builder.setIssuedAt(new Date());
		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();
		return token;
	}
}

