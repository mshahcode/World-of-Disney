package az.pashabank.cardzone.controller;

import az.pashabank.cardzone.model.dto.character.CreateCharacterDTO;
import az.pashabank.cardzone.model.dto.genre.UpdatedGenreDTO;
import az.pashabank.cardzone.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/genres")
@RequiredArgsConstructor
public class GenreController {
    private final GenreService genreService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    UpdatedGenreDTO addGenre(@RequestParam(name = "genreName") String name, @RequestParam("image") MultipartFile imageFile) throws IOException {
        return genreService.addGenre(name, imageFile);
    }
}
