package az.pashabank.cardzone.mapper;

import az.pashabank.cardzone.dao.entity.Character;
import az.pashabank.cardzone.dao.entity.Movie;
import az.pashabank.cardzone.model.dto.character.CreateCharacterDTO;
import az.pashabank.cardzone.model.dto.character.GetListCharactersDTO;
import az.pashabank.cardzone.model.dto.character.NewCharacterDTO;
import az.pashabank.cardzone.model.dto.character.UpdatedCharacterDTO;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-11T17:25:50+0400",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 19.0.2 (Oracle Corporation)"
)
@Component
public class CharacterMapperImpl extends CharacterMapper {

    @Override
    public Character mapCreateCharacterDtoToCharacter(CreateCharacterDTO createCharacterDTO) {
        if ( createCharacterDTO == null ) {
            return null;
        }

        Character character = new Character();

        character.setName( createCharacterDTO.getName() );
        character.setAge( createCharacterDTO.getAge() );
        character.setWeight( createCharacterDTO.getWeight() );
        character.setStory( createCharacterDTO.getStory() );

        return character;
    }

    @Override
    public NewCharacterDTO mapCharacterToNewCharacter(Character character) {
        if ( character == null ) {
            return null;
        }

        NewCharacterDTO newCharacterDTO = new NewCharacterDTO();

        newCharacterDTO.setImage( character.getImage() );
        newCharacterDTO.setId( character.getId() );
        newCharacterDTO.setName( character.getName() );
        newCharacterDTO.setAge( character.getAge() );
        newCharacterDTO.setWeight( character.getWeight() );
        newCharacterDTO.setStory( character.getStory() );
        Set<Movie> set = character.getMovies();
        if ( set != null ) {
            newCharacterDTO.setMovies( new HashSet<Movie>( set ) );
        }

        return newCharacterDTO;
    }

    @Override
    public UpdatedCharacterDTO mapCharacterToUpdatedCharacter(Character character) {
        if ( character == null ) {
            return null;
        }

        UpdatedCharacterDTO updatedCharacterDTO = new UpdatedCharacterDTO();

        updatedCharacterDTO.setId( character.getId() );
        updatedCharacterDTO.setName( character.getName() );
        updatedCharacterDTO.setAge( character.getAge() );
        updatedCharacterDTO.setWeight( character.getWeight() );
        updatedCharacterDTO.setStory( character.getStory() );
        updatedCharacterDTO.setImage( character.getImage() );
        Set<Movie> set = character.getMovies();
        if ( set != null ) {
            updatedCharacterDTO.setMovies( new HashSet<Movie>( set ) );
        }

        return updatedCharacterDTO;
    }

    @Override
    public GetListCharactersDTO mapCharacterToGetListCharactersDTO(Character character) {
        if ( character == null ) {
            return null;
        }

        GetListCharactersDTO getListCharactersDTO = new GetListCharactersDTO();

        getListCharactersDTO.setName( character.getName() );
        getListCharactersDTO.setImage( character.getImage() );

        return getListCharactersDTO;
    }
}
