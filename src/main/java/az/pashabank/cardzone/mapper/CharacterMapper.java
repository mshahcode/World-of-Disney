package az.pashabank.cardzone.mapper;

import az.pashabank.cardzone.dao.entity.Character;
import az.pashabank.cardzone.model.dto.character.CreateCharacterDTO;
import az.pashabank.cardzone.model.dto.character.GetListCharactersDTO;
import az.pashabank.cardzone.model.dto.character.NewCharacterDTO;
import az.pashabank.cardzone.model.dto.character.UpdatedCharacterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public abstract class CharacterMapper {
    public static CharacterMapper INSTANCE = Mappers.getMapper(CharacterMapper.class);

    public abstract Character mapCreateCharacterDtoToCharacter(CreateCharacterDTO createCharacterDTO);

    @Mapping(target = "image", source = "image")
    public abstract NewCharacterDTO mapCharacterToNewCharacter(Character character);

    public abstract UpdatedCharacterDTO mapCharacterToUpdatedCharacter(Character character);

    public abstract GetListCharactersDTO mapCharacterToGetListCharactersDTO(Character character);


}
