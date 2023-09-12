package az.pashabank.cardzone.model.dto.character;

import az.pashabank.cardzone.dao.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCharacterMovieDTO {
    private Long id;
    private String name;
    private Short age;
    private Double weight;
    private String story;
    private Image image;
}
