package az.pashabank.cardzone.service;


import az.pashabank.cardzone.dao.entity.*;
import az.pashabank.cardzone.dao.entity.Character;
import az.pashabank.cardzone.dao.repository.CharacterRepository;
import az.pashabank.cardzone.dao.repository.GenreRepository;
import az.pashabank.cardzone.dao.repository.MovieRepository;
import az.pashabank.cardzone.mapper.CharacterMapper;
import az.pashabank.cardzone.mapper.MovieMapper;
import az.pashabank.cardzone.model.dto.movie.CreateMovieDTO;
import az.pashabank.cardzone.model.dto.movie.MovieUpdateDTO;
import az.pashabank.cardzone.model.dto.movie.NewMovieDTO;
import az.pashabank.cardzone.model.dto.movie.UpdatedMovieDTO;
import az.pashabank.cardzone.utils.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;
    private final GenreRepository genreRepository;


    public NewMovieDTO addMovie(CreateMovieDTO createMovieDTO, MultipartFile movieImage, List<MultipartFile> characterImages) throws IOException {
        Movie movie = MovieMapper.INSTANCE.mapCreateMovieDtoToMovie(createMovieDTO);
        movie.setImage(ImageUtil.saveImageToLocalSystem(movieImage));

        if(createMovieDTO.getGenreIds() != null && !createMovieDTO.getGenreIds().isEmpty()){
            for(Long genre_id : createMovieDTO.getGenreIds()){
                Genre genre = genreRepository.findById(genre_id).orElseThrow(() -> new EntityNotFoundException("No such genre exists with id: " + genre_id));
                movie.addGenre(genre);
            }
        }

        if(createMovieDTO.getCharacters() != null && !createMovieDTO.getCharacters().isEmpty()){
            for(int i = 0; i < createMovieDTO.getCharacters().size(); i++){
                Image image = ImageUtil.saveImageToLocalSystem(characterImages.get(i));
                Character character = CharacterMapper.INSTANCE.mapCreateCharacterDtoToCharacter(createMovieDTO.getCharacters().get(i));
                character.setImage(image);
                character.addMovie(movie);
                characterRepository.save(character);
            }
        }
        return MovieMapper.INSTANCE.mapMovieToNewMovieDTO(movieRepository.save(movie));

    }

    public UpdatedMovieDTO updateMovie(Long movie_id, MovieUpdateDTO movieUpdateDTO) throws IOException {
        Movie movie = movieRepository.findById(movie_id).orElseThrow(() -> new EntityNotFoundException("Movie doesn't exist with id: " + movie_id));
        if(movieUpdateDTO.getTitle() != null && !movieUpdateDTO.getTitle().isEmpty()){
            movie.setTitle(movieUpdateDTO.getTitle());
        }
        if(movieUpdateDTO.getCreatedAt() != null){
            movie.setCreatedAt(movieUpdateDTO.getCreatedAt());
        }
        if(movieUpdateDTO.getRating() != null && !movieUpdateDTO.getRating().isEmpty()){
            movie.setRating(Rating.fromValue(movieUpdateDTO.getRating()));
        }
        if(movieUpdateDTO.getBase64ImageData() != null && !movieUpdateDTO.getBase64ImageData().isEmpty()){
            movie.setImage(ImageUtil.saveBase64ImageToLocalSystem(movieUpdateDTO.getBase64ImageData(),movie_id));
        }
        return MovieMapper.INSTANCE.mapMovieToUpdateMovieDTO(movieRepository.save(movie));
    }

    public Page<UpdatedMovieDTO> findByGenreIdNative(Long genreId, Pageable pageable){
        Page<Movie> movies = movieRepository.findByGenreIdNative(genreId,pageable);
        return movies.map(MovieMapper.INSTANCE::mapMovieToUpdateMovieDTO);

    }

    public void addCharacterToAMovie(Long movieId, Long characterId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new EntityNotFoundException("Movie doesn't exist with id: " + movieId));
        Character character = characterRepository.findById(characterId).orElseThrow(() -> new EntityNotFoundException("Character doesn't exist with id: " + characterId));
        character.addMovie(movie);
        characterRepository.save(character);

    }

    public void removeCharacterFromMovie(Long movieId, Long characterId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new EntityNotFoundException("Movie doesn't exist with id: " + movieId));
        Character character = characterRepository.findById(characterId).orElseThrow(() -> new EntityNotFoundException("Character doesn't exist with id: " + characterId));
        character.removeMovie(movie);
        characterRepository.save(character);
    }

    public void removeMovie(Long movieId) {
        movieRepository.deleteById(movieId);
    }
}
