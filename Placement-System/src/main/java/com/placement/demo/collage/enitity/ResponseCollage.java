package com.placement.demo.collage.enitity;

import com.placement.demo.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseCollage {
	
	private Collage collage;
	private User user;

}
