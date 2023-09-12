package az.pashabank.cardzone.mapper;

import az.pashabank.cardzone.dao.entity.Character;
import az.pashabank.cardzone.dao.entity.Image;
import az.pashabank.cardzone.dao.entity.Movie;
import az.pashabank.cardzone.model.dto.character.NewCharacterMovieDTO;
import az.pashabank.cardzone.model.dto.movie.CreateMovieDTO;
import az.pashabank.cardzone.model.dto.movie.NewMovieDTO;
import az.pashabank.cardzone.model.dto.movie.UpdatedMovieDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

@Mapper(componentModel = "spring")

public abstract class MovieMapper {
    public static MovieMapper INSTANCE = Mappers.getMapper(MovieMapper.class);

    @Mapping(target = "characters", source = "characters")
    public abstract NewMovieDTO mapMovieToNewMovieDTO(Movie movie);

    public abstract NewCharacterMovieDTO mapCharacterToNewCharacterMovieDTO(Character character);

    public abstract UpdatedMovieDTO mapMovieToUpdateMovieDTO(Movie movie);

    @Mapping(target = "characters",ignore = true)
    public abstract Movie mapCreateMovieDtoToMovie(CreateMovieDTO createMovieDTO);
}
