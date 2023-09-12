package az.pashabank.cardzone.dao.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    @Column(name = "created_date")
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private Rating rating;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToMany(mappedBy = "movies", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Character> characters = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movie_genre",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Set<Genre> genres = new HashSet<>();

    // just remove child from the parent entity and hibernate will auto delete parent from this child entity
    @PreRemove
    private void preRemoveAssociations(){
        for (Character character: this.characters){
            character.getMovies().remove(this);
        }

        for(Genre genre : this.genres){
            genre.getMovies().remove(this);
        }
    }

    public void addGenre(Genre genre){
        this.genres.add(genre);
        genre.getMovies().add(this);
    }

    public void remove(Genre genre){
        this.genres.remove(genre);
        genre.getMovies().remove(this);
    }

}
