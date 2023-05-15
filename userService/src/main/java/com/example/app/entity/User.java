package com.example.app.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Table(name="micro_users")
@Getter
@Builder
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	
	@Id
	private String userId;
	private String name;
	private String email;
	private String password;
	private String about;
	@Transient
	private List<Rating>ratings=new ArrayList<>();

}
