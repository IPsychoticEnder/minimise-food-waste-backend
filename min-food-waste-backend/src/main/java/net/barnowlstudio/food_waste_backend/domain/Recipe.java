package net.barnowlstudio.food_waste_backend.domain;

import lombok.*;

import java.util.List;

//@Data                     //Lombok: Auto-create getters/setters
@Getter
@Builder                    //Lombok: Creates constructor with all fields
@NoArgsConstructor          //Lombok: Creates empty constructor
@AllArgsConstructor         //Lombok: Creates constructor with all fields
public class Recipe {
    private Long id;
    private String title;
    private String imageUrl;
    private Integer readyInMinutes;
    private List<String> ingredients;
    private List<String> instructions;
    private Integer servings;
    private Boolean isFavorite;
}
