package com.backend.bistro.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.bistro.entities.Recipe;
import com.backend.bistro.repositories.RecipeRepository;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

	@Autowired
	RecipeRepository recipeRepository;

	@GetMapping(value = "/{recipe_id}")
	public Optional<Recipe> findById(@PathVariable("recipe_id") Integer recipeId) {
		return recipeRepository.findById(recipeId);
	}

}