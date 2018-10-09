package com.backend.bistro.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.backend.bistro.entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

	public List<Ingredient> findByNameContainingIgnoreCase(String name);
	
	public List<Ingredient> findAll();

}
