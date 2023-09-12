package az.pashabank.cardzone.model.dto.character;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCharacterDTO {
    @NotBlank
    private String name;
    @Min(value = 1)
    private Short age;
    @DecimalMin("0.01")
    private Double weight;
    @NotBlank
    private String story;
}
