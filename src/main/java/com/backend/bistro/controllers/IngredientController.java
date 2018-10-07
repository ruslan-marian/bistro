package com.backend.bistro.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.bistro.entities.Ingredient;
import com.backend.bistro.repositories.IngredientRepository;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {

	@Autowired
	IngredientRepository repository;

	@GetMapping("/{ingredient_id}")
	public Optional<Ingredient> findById(@PathVariable("ingredient_id") Integer ingredientId) {
		return repository.findById(ingredientId);
	}

	@GetMapping("/")
	public Iterable<Ingredient> findAll() {
		return repository.findAll();
	}

}
