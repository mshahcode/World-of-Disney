package az.pashabank.cardzone.model.dto.character;


import az.pashabank.cardzone.dao.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetListCharactersDTO {
    private String name;
    private Image image;
}
