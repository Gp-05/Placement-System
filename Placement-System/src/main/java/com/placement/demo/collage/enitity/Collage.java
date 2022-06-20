package com.placement.demo.collage.enitity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.placement.demo.security.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Collage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String address;
	private String mobile;
	private String websiteLink;
	private String course;
	private String time;
	
	@Column(length = 5000)
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@JsonBackReference
	private User user;

	@Override
	public String toString() {
		return "Collage [id=" + id + ", name=" + name + ", address=" + address + ", mobile=" + mobile + ", websiteLink="
				+ websiteLink + ", course=" + course + ", time=" + time + ", description=" + description + "]";
	}
	
	
	
	

}
