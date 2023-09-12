package az.pashabank.cardzone.mapper;

import az.pashabank.cardzone.dao.entity.Genre;
import az.pashabank.cardzone.model.dto.genre.UpdatedGenreDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-11T17:25:50+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class GenreMapperImpl extends GenreMapper {

    @Override
    public UpdatedGenreDTO mapGenreToUpdatedGenre(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        UpdatedGenreDTO updatedGenreDTO = new UpdatedGenreDTO();

        updatedGenreDTO.setId( genre.getId() );
        updatedGenreDTO.setName( genre.getName() );
        updatedGenreDTO.setImage( genre.getImage() );

        return updatedGenreDTO;
    }
}
