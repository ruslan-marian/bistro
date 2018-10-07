package com.backend.bistro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "ingredient")
public class Ingredient {

	@Id
	@GeneratedValue
	private Integer id;

	@Column
	private String name;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
