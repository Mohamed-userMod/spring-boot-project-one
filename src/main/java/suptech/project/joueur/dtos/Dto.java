package suptech.project.joueur.dtos;

import jakarta.validation.constraints.NotEmpty;

public record Dto(@NotEmpty String nom, @NotEmpty String poste, @NotEmpty String equipe_id) {

}
