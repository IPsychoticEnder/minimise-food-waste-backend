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
public class RandomRecipesResponse {
    private List<RecipeResponse> recipes;
}
