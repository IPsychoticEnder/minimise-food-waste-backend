package net.barnowlstudio.food_waste_backend.controller;

import net.barnowlstudio.food_waste_backend.business.ISpoonacularService;
import net.barnowlstudio.food_waste_backend.dto.response.RandomRecipesResponse;
import net.barnowlstudio.food_waste_backend.dto.response.RecipeResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recipes")
@CrossOrigin(origins = "*")
public class RecipesController {
    private final ISpoonacularService spoonacularService;

    public RecipesController(ISpoonacularService spoonacularService) {
        this.spoonacularService = spoonacularService;
    }

    @GetMapping("/random")
    public ResponseEntity<RandomRecipesResponse> getRandomRecipes(@RequestParam(defaultValue = "6") int number){
        RandomRecipesResponse response = spoonacularService.getRandomRecipes(number);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecipeResponse> getRecipeById(@PathVariable int id){
        RecipeResponse response = spoonacularService.getRecipeById(id);
        return ResponseEntity.ok(response);
    }
}
