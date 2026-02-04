package net.barnowlstudio.food_waste_backend.business.impl.Recipe;

import net.barnowlstudio.food_waste_backend.dto.external.SpoonacularIngredient;
import net.barnowlstudio.food_waste_backend.dto.external.SpoonacularRecipeResponse;
import net.barnowlstudio.food_waste_backend.dto.response.RecipeResponse;

import java.util.List;

public class RecipeConverter {
    public static RecipeResponse convert(SpoonacularRecipeResponse spoonacularRecipe){
        return RecipeResponse.builder()
                .id(spoonacularRecipe.getId())
                .title(spoonacularRecipe.getTitle())
                .imageUrl(spoonacularRecipe.getImage())
                .readyInMinutes(spoonacularRecipe.getReadyInMinutes())
                .servings(spoonacularRecipe.getServings())
                .ingredients(extractIngredientNames(spoonacularRecipe))
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
