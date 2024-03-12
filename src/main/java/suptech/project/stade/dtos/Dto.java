package suptech.project.stade.dtos;

import jakarta.validation.constraints.NotNull;

public record Dto(
                @NotNull String nom,
                @NotNull String pays) {

}
