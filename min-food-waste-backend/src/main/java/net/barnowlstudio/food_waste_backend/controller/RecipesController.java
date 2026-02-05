package net.barnowlstudio.food_waste_backend.controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import net.barnowlstudio.food_waste_backend.business.ISpoonacularService;
import net.barnowlstudio.food_waste_backend.dto.response.RandomRecipesResponse;
import net.barnowlstudio.food_waste_backend.dto.response.RecipeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "*")             // TODO: Eventually move it to a config class
public class RecipesController {
    private final ISpoonacularService spoonacularService;

    public RecipesController(ISpoonacularService spoonacularService) {
        this.spoonacularService = spoonacularService;
    }

    @GetMapping("/random")
    public ResponseEntity<RandomRecipesResponse> getRandomRecipes(@RequestParam(defaultValue = "6") @Min(1) @Max(7) int number) {
        RandomRecipesResponse response = spoonacularService.getRandomRecipes(number);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable long id){
        RecipeResponse response = spoonacularService.getRecipeById(id);
        return ResponseEntity.ok(response);
    }
}
