package com.backend.bistro.controllers;

import java.util.List;
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

	/**
	 * Returns ingredient name and id.
	 * <p>
	 * Endpoint: <b>GET: /api/ingredient/{ingredient_id}</b>
	 * 
	 * @param ingredientId
	 *            the id of the ingredient
	 * @return the ingredient with the given id
	 */
	@GetMapping("/{ingredient_id}")
	public Optional<Ingredient> findById(@PathVariable("ingredient_id") Integer ingredientId) {
		return ingredientRepository.findById(ingredientId);
	}

	/**
	 * Returns ingredient(s) by the given {@code name}. <br>
	 * If {@code name} is omitted then all existing ingredients are returned.
	 * <p>
	 * Endpoint: <b>GET: /api/ingredient</b>
	 * Endpoint: <b>GET: /api/ingredient?q={search_string}</b>
	 * 
	 * @param name
	 *            optional parameter
	 * @return the matching ingredients
	 */
	@GetMapping
	public List<Ingredient> find(@RequestParam(value = "q", required = false) String name) {
		if (name == null) {
			return findAll();
		}
		return findByName(name);
	}

	private List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}

	private List<Ingredient> findByName(String name) {
		return ingredientRepository.findByNameContainingIgnoreCase(name);
	}

	/**
	 * Creates a new ingredient.
	 * <p>
	 * Endpoint: <b>POST: /api/ingredient</b>
	 * 
	 * @param ingredient
	 *            the new ingredient
	 * @return the created ingredient with the new id
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Ingredient create(@RequestBody Ingredient ingredient) {
		return ingredientRepository.save(ingredient);
	}

	/**
	 * Changes the name of an existing ingredient.
	 * <p>
	 * Endpoint: <b>PUT: /api/ingredient/{ingredient_id}</b>
	 * 
	 * @param recipe
	 *            the ingredient to be updated
	 * @param ingredientId
	 *            the id of the ingredient to be updated
	 * @return the saved ingredient
	 */
	@PutMapping("/{ingredient_id}")
	public Ingredient update(@RequestBody Ingredient ingredient, @PathVariable("ingredient_id") Integer ingredientId) {
		ingredientRepository.findById(ingredientId);
		return ingredientRepository.save(ingredient);
	}

}
