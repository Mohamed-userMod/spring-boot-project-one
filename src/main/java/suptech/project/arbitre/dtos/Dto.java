package suptech.project.arbitre.dtos;

import jakarta.validation.constraints.NotEmpty;

public record Dto(@NotEmpty(message = "Le nom de l'arbitre ne peut pas etre null") String nom,
        @NotEmpty(message = "La nationalite de l'arbitre ne peut pas etre null") String nationalite) {

}
