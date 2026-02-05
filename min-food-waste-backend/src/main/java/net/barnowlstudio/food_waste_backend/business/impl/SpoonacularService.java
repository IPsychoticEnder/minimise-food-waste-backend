package net.barnowlstudio.food_waste_backend.business.impl;

import net.barnowlstudio.food_waste_backend.business.converters.RecipeConverter;
import net.barnowlstudio.food_waste_backend.dto.external.SpoonacularRecipeResponse;
import org.springframework.beans.factory.annotation.Value;
import net.barnowlstudio.food_waste_backend.business.ISpoonacularService;
import net.barnowlstudio.food_waste_backend.dto.external.SpoonacularRandomRecipesResponse;
import net.barnowlstudio.food_waste_backend.dto.response.RandomRecipesResponse;
import net.barnowlstudio.food_waste_backend.dto.response.RecipeResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class SpoonacularService implements ISpoonacularService {
    private final RestTemplate restTemplate;

    @Value("${spoonacular.api.key}")
    private String apiKey;

    public SpoonacularService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public RandomRecipesResponse getRandomRecipes(int numberOfRecipes){
        String url = String.format(
                "https://api.spoonacular.com/recipes/random?apiKey=%s&number=%d",
                apiKey,
                numberOfRecipes
        );

        SpoonacularRandomRecipesResponse spoonacularResponse = restTemplate.getForObject(url, SpoonacularRandomRecipesResponse.class);

        if (spoonacularResponse == null || spoonacularResponse.getRecipes() == null) {
            throw new ResponseStatusException(BAD_GATEWAY, "Failed to fetch recipes from Spoonacular");
        }

        List<RecipeResponse> recipes = spoonacularResponse.getRecipes()
                .stream()
                .map(RecipeConverter::toDomain)
                .map(RecipeConverter::toResponse)
                .toList();

        return RandomRecipesResponse.builder().recipes(recipes).build();
    }

    @Override
    public RecipeResponse getRecipeById(long recipeId){
        String url = String.format(
                "https://api.spoonacular.com/recipes/%d/information?apiKey=%s",
                recipeId,
                apiKey
        );

        SpoonacularRecipeResponse spoonacularResponse = restTemplate.getForObject(url, SpoonacularRecipeResponse.class);

        if (spoonacularResponse == null) {
            throw new ResponseStatusException(NOT_FOUND, "Recipe not found");
        }

        var domain = RecipeConverter.toDomain(spoonacularResponse);
        return RecipeConverter.toResponse(domain);
    }
}
