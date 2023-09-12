package az.pashabank.cardzone.controller;

import az.pashabank.cardzone.model.dto.character.*;
import az.pashabank.cardzone.service.CharacterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/characters")
@RequiredArgsConstructor
public class CharacterController {
    private final CharacterService characterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    Page<GetListCharactersDTO> getCharacters(Pageable pageable){
        return characterService.getCharacters(pageable);
    }

    @GetMapping(params = "name")
    @ResponseStatus(HttpStatus.OK)
    Page<GetListCharactersDTO> getCharactersByName(@RequestParam("name") String name, Pageable pageable){
        return characterService.getCharactersByName(name,pageable);
    }

    @GetMapping(params = "age")
    @ResponseStatus(HttpStatus.OK)
    Page<GetListCharactersDTO> getCharactersByAge(@RequestParam("age") Short age, Pageable pageable){
        return characterService.getCharactersByAge(age,pageable);
    }

    @GetMapping(params = "movieId")
    @ResponseStatus(HttpStatus.OK)
    Page<GetListCharactersDTO> getCharactersByMovieId(@RequestParam("movieId") Long movieId, Pageable pageable){
        return characterService.getCharactersByMovieId(movieId,pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    NewCharacterDTO addCharacter(@ModelAttribute @Valid CreateCharacterDTO createCharacterDTO, @RequestParam("image") MultipartFile imageFile) throws IOException {
        return characterService.addCharacter(createCharacterDTO, imageFile);
    }

    @PutMapping(value = "/{character_id}")
    @ResponseStatus(HttpStatus.OK)
    UpdatedCharacterDTO updatedCharacter(@PathVariable Long character_id, @ModelAttribute @Valid CharacterUpdateDTO characterUpdateDTO, @RequestParam(value = "image",required = false) MultipartFile imageFile) throws IOException{
        return characterService.updateCharacter(character_id,characterUpdateDTO,imageFile);
    }

    @DeleteMapping(value = "/{character_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCharacter(@PathVariable Long character_id){
        characterService.deleteCharacter(character_id);
    }


}
