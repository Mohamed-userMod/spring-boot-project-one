package suptech.project.match.dtos;

import java.sql.Time;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public record Dto(
                @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") @NotNull(message = "Veuillez renseigner une date.") LocalDateTime date,
                @NotNull(message = "Veuillez renseingez une heure.") Time time,
                @NotNull(message = "Veuillez renseigner un stade.") String stade_id,
                @NotNull(message = "Veuillez renseigner un arbitre.") String arbitre_id,
                @NotNull(message = "Veuillez renseigner une equipe 1.") String equipe_1_id,
                @NotNull(message = "Veuillez renseigner une equipe 2.") String equipe_2_id) {

}
