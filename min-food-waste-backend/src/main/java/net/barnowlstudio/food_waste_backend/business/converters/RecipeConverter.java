package net.barnowlstudio.food_waste_backend.business.converters;

import net.barnowlstudio.food_waste_backend.domain.Recipe;
import net.barnowlstudio.food_waste_backend.dto.external.SpoonacularIngredient;
import net.barnowlstudio.food_waste_backend.dto.external.SpoonacularRecipeResponse;
import net.barnowlstudio.food_waste_backend.dto.response.RecipeResponse;

import java.util.List;

public class RecipeConverter {
    public static Recipe toDomain(SpoonacularRecipeResponse spoonacularRecipe){
        return Recipe.builder()
                .id(spoonacularRecipe.getId())
                .title(spoonacularRecipe.getTitle())
                .imageUrl(spoonacularRecipe.getImage())
                .readyInMinutes(spoonacularRecipe.getReadyInMinutes())
                .servings(spoonacularRecipe.getServings())
                .ingredients(extractIngredientNames(spoonacularRecipe))
                .build();
    }

    public static RecipeResponse toResponse(Recipe recipe){
        return RecipeResponse.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .imageUrl(recipe.getImageUrl())
                .readyInMinutes(recipe.getReadyInMinutes())
                .servings(recipe.getServings())
                .ingredients(recipe.getIngredients())
                .build();
    }

    private static List<String> extractIngredientNames(SpoonacularRecipeResponse spoonacularRecipe){
        if (spoonacularRecipe.getExtendedIngredients() == null){
            return List.of();
        }

        return spoonacularRecipe.getExtendedIngredients()
                .stream()
                .map(SpoonacularIngredient::getOriginal)
                .toList();
    }
}
