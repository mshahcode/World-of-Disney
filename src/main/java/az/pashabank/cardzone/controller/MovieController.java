package az.pashabank.cardzone.controller;

import az.pashabank.cardzone.model.dto.movie.CreateMovieDTO;
import az.pashabank.cardzone.model.dto.movie.MovieUpdateDTO;
import az.pashabank.cardzone.model.dto.movie.NewMovieDTO;
import az.pashabank.cardzone.model.dto.movie.UpdatedMovieDTO;
import az.pashabank.cardzone.service.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController{
    private final MovieService movieService;
    private final ObjectMapper objectMapper;


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public NewMovieDTO createMovie(
            @RequestPart("movie") String jsonMovie,
            @RequestParam("movieImage") MultipartFile movieImageFile,
            @RequestParam(value = "characterImages", required = false) List<MultipartFile> characterImageFiles
    ) throws IOException {
        objectMapper.registerModule(new JavaTimeModule());
        CreateMovieDTO createMovieDTO = objectMapper.readValue(jsonMovie,CreateMovieDTO.class);
        return movieService.addMovie(createMovieDTO,movieImageFile,characterImageFiles);
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public NewMovieDTO createMovieV2(
            @ModelAttribute @Valid CreateMovieDTO createMovieDTO,
            @RequestParam("movieImage") MultipartFile movieImageFile,
            @RequestParam(value = "characterImages", required = false) List<MultipartFile> characterImageFiles
    ) throws IOException {
        return movieService.addMovie(createMovieDTO,movieImageFile,characterImageFiles);
    }

    @PutMapping("/{movie_id}")
    @ResponseStatus(HttpStatus.OK)
    UpdatedMovieDTO updateMovie(@PathVariable Long movie_id,@RequestBody @Valid MovieUpdateDTO movieUpdateDTO) throws IOException {
        return movieService.updateMovie(movie_id,movieUpdateDTO);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<UpdatedMovieDTO> findByGenreIdNative(@RequestParam(value = "genreId", required = false) Long genreId, Pageable pageable){
        return movieService.findByGenreIdNative(genreId,pageable);
    }

    @PostMapping("/{movie_id}/characters/{character_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void addCharacterToMovie(@PathVariable Long movie_id, @PathVariable Long character_id){
        movieService.addCharacterToAMovie(movie_id, character_id);
    }


    @DeleteMapping("/{movie_id}/characters/{character_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeCharacterFromMovie(@PathVariable Long movie_id, @PathVariable Long character_id){
        movieService.removeCharacterFromMovie(movie_id, character_id);
    }

    @DeleteMapping("/{movie_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void removeMovie(@PathVariable Long movie_id){
        movieService.removeMovie(movie_id);
    }


}