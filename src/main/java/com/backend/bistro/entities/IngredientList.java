package com.backend.bistro.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ingredient_list")
public class IngredientList {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "recipe_id")
	private Integer recipeId;

	@Column(name = "ingredient_id")
	private Integer ingredientId;

	@Column
	private Integer amount;

	protected IngredientList() {
	}

}
