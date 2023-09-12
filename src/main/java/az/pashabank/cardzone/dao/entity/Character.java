    package az.pashabank.cardzone.dao.entity;


    import lombok.*;
    import lombok.experimental.FieldDefaults;

    import javax.persistence.*;
    import javax.validation.constraints.NotBlank;
    import javax.validation.constraints.NotNull;
    import java.util.HashSet;
    import java.util.Set;

    @Entity
    @Table(name = "characters")
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public class Character {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @NotBlank
        private String name;

        @NotNull
        private Short age;

        @NotNull
        private Double weight;

        @Column(columnDefinition="TEXT")
        @NotBlank
        private String story;

        @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
        @JoinColumn(name = "image_id")

        private Image image;
        @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
        @JoinTable(
                name = "character_movie",
                joinColumns = @JoinColumn(name = "character_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id")
        )
        private Set<Movie> movies = new HashSet<>();

        public void addMovie(Movie movie) {
            this.movies.add(movie);
            movie.getCharacters().add(this);
        }

        public void removeMovie(Movie movie) {
            this.movies.remove(movie);
            movie.getCharacters().remove(this);
        }
    }
