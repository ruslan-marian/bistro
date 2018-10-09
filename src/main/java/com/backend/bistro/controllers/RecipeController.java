package com.backend.bistro.controllers;

import java.util.List;

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

import com.backend.bistro.entities.IngredientList;
import com.backend.bistro.entities.Recipe;
import com.backend.bistro.repositories.RecipeRepository;

@RestController
@RequestMapping("/api/recipe")
public class RecipeController {

	@Autowired
	RecipeRepository recipeRepository;

	/**
	 * Returns the recipe by the given {recipe_id}.
	 * <p>
	 * Endpoint: <b>GET: /api/recipe/{recipe_id}</b>
	 * 
	 * @param recipeId
	 *            the id of the recipe to get
	 * @param people
	 *            an optional query param (?p={people}) that recalculates the
	 *            recipe to fit for that amount of people
	 * @return the recipe with the given id
	 */
	@GetMapping(value = "/{recipe_id}")
	public Recipe findById(@PathVariable("recipe_id") Integer recipeId,
			@RequestParam(value = "p", required = false) Integer people) {

		Recipe recipe = recipeRepository.findById(recipeId).get();

		if (people != null && recipe.getPeople() != people) {
			return recalculate(recipe, people);
		}
		return recipe;
	}

	/**
	 * Recalculates the recipe to fit that amount of people
	 * 
	 * @param recipe
	 *            the given recipe
	 * @param people
	 *            the new amount of people
	 * @return the recalculated recipe
	 */
	private Recipe recalculate(Recipe recipe, Integer people) {

		double factor = (double) people / recipe.getPeople();

		for (IngredientList ingr : recipe.getIngredients()) {
			ingr.setAmount((int) Math.round(ingr.getAmount() * factor));
		}

		recipe.setPeople(people);

		return recipe;
	}

	/**
	 * Searches for recipe by name. All recipes with names containing the search
	 * string are returned
	 * <p>
	 * Endpoint: <b>GET: /api/recipe?q={search_string}</b>
	 * 
	 * @param name
	 *            the name of the recipe(s) to be found.
	 * @return
	 */
	@GetMapping
	public List<Recipe> findByName(@RequestParam(value = "q", required = true) String name) {
		return recipeRepository.findByNameContainingIgnoreCase(name);
	}

	/**
	 * Creates a new recipe.
	 * <p>
	 * Endpoint: <b>POST: /api/recipe</b>
	 * 
	 * @param recipe
	 *            the new recipe
	 * @return the created recipe with the new id
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Recipe create(@RequestBody Recipe recipe) {
		return recipeRepository.save(recipe);
	}

	/**
	 * Updates an already existing recipe.
	 * <p>
	 * Endpoint: <b>PUT: /api/recipe/{recipe_id}</b>
	 * 
	 * @param recipe
	 *            the recipe to be updated
	 * @param recipeId
	 *            the id of the recipe to be updated
	 * @return the saved recipe
	 */
	@PutMapping("/{recipe_id}")
	public Recipe update(@RequestBody Recipe recipe, @PathVariable("recipe_id") Integer recipeId) {
		recipeRepository.findById(recipeId);
		return recipeRepository.save(recipe);
	}

}
