package net.barnowlstudio.food_waste_backend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecipeResponse {
    private Long id;
    private String title;
    private String imageUrl;
    private Integer readyInMinutes;
    private Integer servings;
    private List<String> ingredients;
}
