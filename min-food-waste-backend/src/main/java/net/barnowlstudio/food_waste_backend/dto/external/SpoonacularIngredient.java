package net.barnowlstudio.food_waste_backend.dto.external;

import lombok.Data;

@Data
public class SpoonacularIngredient {
    private Long id;
    private String original;
    private String name;
}
