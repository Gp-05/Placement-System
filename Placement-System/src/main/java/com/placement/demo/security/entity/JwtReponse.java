package com.placement.demo.security.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtReponse {

	private CommonUser user;
	private String jwttoken;


}
