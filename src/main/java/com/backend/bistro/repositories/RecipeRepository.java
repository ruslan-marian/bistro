package com.backend.bistro.repositories;

import org.springframework.data.repository.CrudRepository;

import com.backend.bistro.entities.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {

}
