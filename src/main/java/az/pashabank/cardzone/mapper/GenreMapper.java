package az.pashabank.cardzone.mapper;


import az.pashabank.cardzone.dao.entity.Genre;
import az.pashabank.cardzone.model.dto.genre.UpdatedGenreDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public abstract class GenreMapper {
    public static GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);

    public abstract UpdatedGenreDTO mapGenreToUpdatedGenre(Genre genre);



}
