package com.plateer.homemarket.util;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.plateer.homemarket.entity.enumType.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtUtil {
	
	private long accessTokenValidTime = TimeUnit.HOURS.toMillis(1);
	
	private final UserDetailsService userDetailsService;
	
	//토큰을 복호화할 때 사용할 비밀키
	@Value("${token.secretKey}")
	private String secretKey;
	
	@PostConstruct
	public void init() {
		secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
	}
	
	//JWT 토큰 생성
	public String createAccessToken(String user, List<Role> roles) {
		Claims claims = Jwts.claims().setSubject(user);
		claims.put("roles", roles);
		Date now = new Date();
		
		return Jwts.builder()
				.setClaims(claims)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + accessTokenValidTime))
				.signWith(SignatureAlgorithm.HS256, secretKey)
				.compact();
	}
	
	public Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("AUTH_TOKEN");
		UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUsername(token));
		return new UsernamePasswordAuthenticationToken(userDetails, "",userDetails.getAuthorities());
	}
	
	private String getUsername(String token) {
		// TODO Auto-generated method stub
		return Jwts.parser().setSigningKey(secretKey).parsePlaintextJws(token).getBody();
	}

	public boolean validateToken(HttpServletRequest request) {
		String token = request.getHeader("AUTH_TOKEN");
		if(token == null) return false;
		try {
			Jwts.parser().setSigningKey(secretKey).parsePlaintextJws(token);
		}catch(Exception e) {
			request.setAttribute("exception", e.getClass().getSimpleName());
			return false;
		}
		return true;
	}

}
