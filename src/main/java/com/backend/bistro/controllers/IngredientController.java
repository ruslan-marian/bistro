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

import com.backend.bistro.entities.Ingredient;
import com.backend.bistro.repositories.IngredientRepository;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

	@Autowired
	IngredientRepository ingredientRepository;

	@GetMapping("/{ingredient_id}")
	public Optional<Ingredient> findById(@PathVariable("ingredient_id") Integer ingredientId) {
		return ingredientRepository.findById(ingredientId);
	}

	@GetMapping
	public Iterable<Ingredient> find(@RequestParam(value = "q", required = false) String name) {
		if (name == null) {
			return findAll();
		}
		return findByName(name);
	}

	private Iterable<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	private Iterable<Ingredient> findByName(String name) {
		return ingredientRepository.findByNameContainingIgnoreCase(name);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	@PutMapping("/{ingredient_id}")
	public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable("ingredient_id") Integer ingredientId) {
		ingredientRepository.findById(ingredientId);
		return ingredientRepository.save(ingredient);
	}

}
