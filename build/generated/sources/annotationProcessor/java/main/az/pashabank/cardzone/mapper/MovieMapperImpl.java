package az.pashabank.cardzone.mapper;

import az.pashabank.cardzone.dao.entity.Character;
import az.pashabank.cardzone.dao.entity.Genre;
import az.pashabank.cardzone.dao.entity.Movie;
import az.pashabank.cardzone.dao.entity.Rating;
import az.pashabank.cardzone.model.dto.character.NewCharacterMovieDTO;
import az.pashabank.cardzone.model.dto.genre.GenreDTO;
import az.pashabank.cardzone.model.dto.movie.CreateMovieDTO;
import az.pashabank.cardzone.model.dto.movie.NewMovieDTO;
import az.pashabank.cardzone.model.dto.movie.UpdatedMovieDTO;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-11T18:00:32+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class MovieMapperImpl extends MovieMapper {

    @Override
    public NewMovieDTO mapMovieToNewMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        NewMovieDTO newMovieDTO = new NewMovieDTO();

        newMovieDTO.setCharacters( characterSetToNewCharacterMovieDTOHashSet( movie.getCharacters() ) );
        newMovieDTO.setId( movie.getId() );
        newMovieDTO.setTitle( movie.getTitle() );
        newMovieDTO.setCreatedAt( movie.getCreatedAt() );
        newMovieDTO.setRating( movie.getRating() );
        newMovieDTO.setGenres( genreSetToGenreDTOHashSet( movie.getGenres() ) );

        return newMovieDTO;
    }

    @Override
    public NewCharacterMovieDTO mapCharacterToNewCharacterMovieDTO(Character character) {
        if ( character == null ) {
            return null;
        }

        NewCharacterMovieDTO newCharacterMovieDTO = new NewCharacterMovieDTO();

        newCharacterMovieDTO.setId( character.getId() );
        newCharacterMovieDTO.setName( character.getName() );
        newCharacterMovieDTO.setAge( character.getAge() );
        newCharacterMovieDTO.setWeight( character.getWeight() );
        newCharacterMovieDTO.setStory( character.getStory() );
        newCharacterMovieDTO.setImage( character.getImage() );

        return newCharacterMovieDTO;
    }

    @Override
    public UpdatedMovieDTO mapMovieToUpdateMovieDTO(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        UpdatedMovieDTO updatedMovieDTO = new UpdatedMovieDTO();

        updatedMovieDTO.setId( movie.getId() );
        updatedMovieDTO.setTitle( movie.getTitle() );
        updatedMovieDTO.setCreatedAt( movie.getCreatedAt() );
        updatedMovieDTO.setRating( movie.getRating() );
        updatedMovieDTO.setImage( movie.getImage() );
        updatedMovieDTO.setGenres( genreSetToGenreDTOHashSet( movie.getGenres() ) );
        updatedMovieDTO.setCharacters( characterSetToNewCharacterMovieDTOHashSet1( movie.getCharacters() ) );

        return updatedMovieDTO;
    }

    @Override
    public Movie mapCreateMovieDtoToMovie(CreateMovieDTO createMovieDTO) {
        if ( createMovieDTO == null ) {
            return null;
        }

        Movie movie = new Movie();

        movie.setTitle( createMovieDTO.getTitle() );
        movie.setCreatedAt( createMovieDTO.getCreatedAt() );
        if ( createMovieDTO.getRating() != null ) {
            movie.setRating( Enum.valueOf( Rating.class, createMovieDTO.getRating() ) );
        }

        return movie;
    }

    protected HashSet<NewCharacterMovieDTO> characterSetToNewCharacterMovieDTOHashSet(Set<Character> set) {
        if ( set == null ) {
            return null;
        }

        HashSet<NewCharacterMovieDTO> hashSet = new HashSet<NewCharacterMovieDTO>();
        for ( Character character : set ) {
            hashSet.add( mapCharacterToNewCharacterMovieDTO( character ) );
        }

        return hashSet;
    }

    protected GenreDTO genreToGenreDTO(Genre genre) {
        if ( genre == null ) {
            return null;
        }

        GenreDTO genreDTO = new GenreDTO();

        genreDTO.setId( genre.getId() );
        genreDTO.setName( genre.getName() );
        genreDTO.setImage( genre.getImage() );

        return genreDTO;
    }

    protected HashSet<GenreDTO> genreSetToGenreDTOHashSet(Set<Genre> set) {
        if ( set == null ) {
            return null;
        }

        HashSet<GenreDTO> hashSet = new HashSet<GenreDTO>();
        for ( Genre genre : set ) {
            hashSet.add( genreToGenreDTO( genre ) );
        }

        return hashSet;
    }

    protected HashSet<NewCharacterMovieDTO> characterSetToNewCharacterMovieDTOHashSet1(Set<Character> set) {
        if ( set == null ) {
            return null;
        }

        HashSet<NewCharacterMovieDTO> hashSet = new HashSet<NewCharacterMovieDTO>();
        for ( Character character : set ) {
            hashSet.add( mapCharacterToNewCharacterMovieDTO( character ) );
        }

        return hashSet;
    }
}
