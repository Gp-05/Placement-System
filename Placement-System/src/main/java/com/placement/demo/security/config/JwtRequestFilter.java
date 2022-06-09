package com.placement.demo.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.placement.demo.security.services.JwtService;
import com.placement.demo.security.util.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUtil jwtutil;
	
	@Autowired
	private JwtService jwtservice;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String header = request.getHeader("Authorization");
 
		String jwttoken = null;
		String username = null;
		
		if (header != null && header.startsWith("Bearer ")) {
			jwttoken = header.substring(7);

			try {
				username = jwtutil.getUserNameFromToken(jwttoken);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get Jwt Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT token is Expired");
			}
		} else {
			System.out.println("Jwt token does not start with Bearer ! ");
		}

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			
			//admin
			//collage
			//offcer
			//student
			UserDetails userDetails = jwtservice.loadUserByUsername(username);

			if (jwtutil.validateToken(jwttoken, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());

				usernamePasswordAuthenticationToken
						.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}

		filterChain.doFilter(request, response);

		
	}
}
