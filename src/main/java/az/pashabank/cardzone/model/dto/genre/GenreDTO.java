package az.pashabank.cardzone.model.dto.genre;

import az.pashabank.cardzone.dao.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {
    private Long id;
    private String name;
    private Image image;
}
