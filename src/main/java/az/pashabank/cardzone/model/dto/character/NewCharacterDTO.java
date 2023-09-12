package az.pashabank.cardzone.model.dto.character;


import az.pashabank.cardzone.dao.entity.Image;
import az.pashabank.cardzone.dao.entity.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewCharacterDTO {
    private Long id;
    private String name;
    private Short age;
    private Double weight;
    private String story;
    private Image image;
    private HashSet<Movie> movies;
}
