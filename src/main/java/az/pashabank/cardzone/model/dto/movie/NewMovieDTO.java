package az.pashabank.cardzone.model.dto.movie;

import az.pashabank.cardzone.dao.entity.Character;
import az.pashabank.cardzone.dao.entity.Genre;
import az.pashabank.cardzone.dao.entity.Rating;
import az.pashabank.cardzone.model.dto.character.CreateCharacterDTO;
import az.pashabank.cardzone.model.dto.character.NewCharacterDTO;
import az.pashabank.cardzone.model.dto.character.NewCharacterMovieDTO;
import az.pashabank.cardzone.model.dto.genre.GenreDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewMovieDTO {
    private Long id;
    private String title;
    private LocalDate createdAt;
    private Rating rating;
    private HashSet<GenreDTO> genres;
    private HashSet<NewCharacterMovieDTO> characters;
}
