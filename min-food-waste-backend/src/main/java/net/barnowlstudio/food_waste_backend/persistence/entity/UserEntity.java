package net.barnowlstudio.food_waste_backend.persistence.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
