package az.pashabank.cardzone.service;

import az.pashabank.cardzone.dao.entity.Character;
import az.pashabank.cardzone.dao.entity.Image;
import az.pashabank.cardzone.dao.entity.Movie;
import az.pashabank.cardzone.dao.repository.CharacterRepository;
import az.pashabank.cardzone.mapper.CharacterMapper;
import az.pashabank.cardzone.model.dto.character.*;
import az.pashabank.cardzone.utils.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;


@Service
@RequiredArgsConstructor
public class CharacterService {
    private final CharacterRepository characterRepository;
    private static final Log log = LogFactory.getLog(CharacterService.class);

    public NewCharacterDTO addCharacter(CreateCharacterDTO createCharacterDTO, MultipartFile imageFile) throws IOException {
        Image image = ImageUtil.saveImageToLocalSystem(imageFile);
        Character character = CharacterMapper.INSTANCE.mapCreateCharacterDtoToCharacter(createCharacterDTO);
        character.setImage(image);
        return CharacterMapper.INSTANCE.mapCharacterToNewCharacter(characterRepository.save(character));
    }

    @Transactional
    public void deleteCharacter(Long characterId) {
        Character character = characterRepository.findById(characterId).
                orElseThrow(() -> new EntityNotFoundException("No character exists with id: " + characterId));
        for(Movie movie: character.getMovies()){ character.removeMovie(movie);}
        character.setImage(null);
        characterRepository.delete(character);
    }

    public UpdatedCharacterDTO updateCharacter(Long characterId, CharacterUpdateDTO characterUpdateDTO, MultipartFile imageFile) throws IOException {
        Character character = characterRepository.findById(characterId).
                orElseThrow(() -> new EntityNotFoundException("No character exists with id: " + characterId));
        if(imageFile != null && !imageFile.isEmpty()){
            Image image = ImageUtil.saveImageToLocalSystem(imageFile);
            character.setImage(image);
        }
        if(characterUpdateDTO.getName() != null && !characterUpdateDTO.getName().isEmpty()){
            character.setName(characterUpdateDTO.getName());
        }
        if (characterUpdateDTO.getAge() != null) {
            character.setAge(characterUpdateDTO.getAge());
        }
        if (characterUpdateDTO.getWeight() != null) {
            character.setWeight(characterUpdateDTO.getWeight());
        }
        if (characterUpdateDTO.getStory() != null && !characterUpdateDTO.getStory().isEmpty()) {
            character.setStory(characterUpdateDTO.getStory());
        }
        return CharacterMapper.INSTANCE.mapCharacterToUpdatedCharacter(characterRepository.save(character));
    }

    public Page<GetListCharactersDTO> getCharacters(Pageable pageable) {
        Page<Character> characters = characterRepository.findAll(pageable);
        return characters.map(CharacterMapper.INSTANCE::mapCharacterToGetListCharactersDTO);
    }

    public Page<GetListCharactersDTO> getCharactersByName(String name, Pageable pageable){
        Page<Character> characters = characterRepository.getCharactersByName(name,pageable);
        return characters.map(CharacterMapper.INSTANCE::mapCharacterToGetListCharactersDTO);
    }

    public Page<GetListCharactersDTO> getCharactersByAge(Short age, Pageable pageable) {
        Page<Character> characters = characterRepository.getCharactersByAge(age,pageable);
        return characters.map(CharacterMapper.INSTANCE::mapCharacterToGetListCharactersDTO);
    }

    public Page<GetListCharactersDTO> getCharactersByMovieId(Long movieId, Pageable pageable) {
        Page<Character> characters = characterRepository.getCharactersByMovieId(movieId,pageable);
        return characters.map(CharacterMapper.INSTANCE::mapCharacterToGetListCharactersDTO);
    }
}
