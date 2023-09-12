package az.pashabank.cardzone.model.dto.movie;

import az.pashabank.cardzone.dao.entity.Image;
import az.pashabank.cardzone.dao.entity.Rating;
import az.pashabank.cardzone.model.dto.character.NewCharacterMovieDTO;
import az.pashabank.cardzone.model.dto.genre.GenreDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatedMovieDTO {
    private Long id;
    private String title;
    private LocalDate createdAt;
    private Rating rating;
    private Image image;
    private HashSet<GenreDTO> genres;
    private HashSet<NewCharacterMovieDTO> characters;
}
