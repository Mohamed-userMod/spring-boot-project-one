package suptech.project.match.dtos;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.validation.constraints.NotNull;

public record UpdateDto(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss") @NotNull(message = "Veuillez renseigner une date.") LocalDateTime date,
        Time time,
        String stade_id,
        String arbitre_id,
        String equipe_1_id,
        String equipe_2_id) {

}
