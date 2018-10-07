package com.backend.bistro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "recipe")
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String name;
	@Column
	private Integer people;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Integer getPeople() {
		return people;
	}

}
