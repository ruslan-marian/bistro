package com.backend.bistro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.backend.bistro.entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {

	public Iterable<Ingredient> findByNameContainingIgnoreCase(String name);

}
