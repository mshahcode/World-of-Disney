package az.pashabank.cardzone.model.dto.character;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharacterUpdateDTO {
    private String name;
    @Min(value = 1)
    private Short age;
    @DecimalMin(value = "0.01")
    private Double weight;
    private String story;
}
