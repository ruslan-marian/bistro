package com.backend.bistro.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="ingredient")
public class Ingredient {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;

}
