package net.barnowlstudio.food_waste_backend.business;

import net.barnowlstudio.food_waste_backend.dto.response.RandomRecipesResponse;
import net.barnowlstudio.food_waste_backend.dto.response.RecipeResponse;

public interface ISpoonacularService {
    RandomRecipesResponse getRandomRecipes(int numberOfRecipes);

    RecipeResponse getRecipeById(int recipeId);
}
