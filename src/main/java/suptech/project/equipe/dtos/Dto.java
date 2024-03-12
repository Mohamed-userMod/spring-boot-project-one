package suptech.project.equipe.dtos;

import jakarta.validation.constraints.NotEmpty;

public record Dto(@NotEmpty String nom,
        @NotEmpty String pays) {

}
