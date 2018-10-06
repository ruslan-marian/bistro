package com.backend.bistro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="recipe")
public class Recipe {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Integer people;
	
}
