package net.barnowlstudio.food_waste_backend.dto.external;

import lombok.Data;

import java.util.List;

@Data
public class SpoonacularRecipeResponse {
    private long id;
    private String title;
    private String image;
    private Integer readyInMinutes;
    private Integer servings;
    private List<SpoonacularIngredient> extendedIngredients;
}
