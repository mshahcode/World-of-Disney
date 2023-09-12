    package az.pashabank.cardzone.model.dto.movie;

    import az.pashabank.cardzone.model.dto.character.CreateCharacterDTO;
    import com.fasterxml.jackson.annotation.JsonFormat;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;
    import org.springframework.format.annotation.DateTimeFormat;

    import javax.validation.constraints.NotBlank;
    import javax.validation.constraints.NotEmpty;
    import javax.validation.constraints.NotNull;
    import javax.validation.constraints.Size;
    import java.time.LocalDate;
    import java.util.List;
    import java.util.Set;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CreateMovieDTO {
        @NotBlank
        private String title;

        @NotNull
        @JsonFormat(pattern = "yyyy-MM-dd")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate createdAt;

        @NotBlank
        private String rating;

        private List<CreateCharacterDTO> characters;

        @NotEmpty
        @Size(min = 1)
        private List<Long> genreIds;

    }
