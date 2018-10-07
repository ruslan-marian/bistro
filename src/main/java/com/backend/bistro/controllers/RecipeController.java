package com.backend.bistro.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
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

	@GetMapping
	public Iterable<Recipe> findByName(@RequestParam(value = "q", required = true) String name) {
		return recipeRepository.findByNameContainingIgnoreCase(name);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Recipe create(@RequestBody Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	@PutMapping
	public Recipe update(@RequestBody Recipe recipe, @PathVariable("recipe_id") Integer recipeId) {
		recipeRepository.findById(recipeId);
		return recipeRepository.save(recipe);
	}

}
