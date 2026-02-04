package net.barnowlstudio.food_waste_backend.dto.external;

import lombok.Data;

import java.util.List;

@Data
public class SpoonacularRandomRecipesResponse {
    private List<SpoonacularRecipeResponse> recipes;
}
