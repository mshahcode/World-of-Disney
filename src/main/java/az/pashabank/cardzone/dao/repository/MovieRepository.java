package az.pashabank.cardzone.dao.repository;

import az.pashabank.cardzone.dao.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    @Query(value = "SELECT * FROM movies m LEFT JOIN movie_genre mv ON m.id = mv.movie_id WHERE (:genreId IS NULL OR mv.genre_id = :genreId)"
            ,countQuery ="SELECT COUNT(*) FROM movies m LEFT JOIN movie_genre mv ON m.id = mv.movie_id WHERE (:genreId IS NULL OR mv.genre_id = :genreId)" , nativeQuery = true)
    Page<Movie> findByGenreIdNative(@Param("genreId") Long genreId, Pageable pageable);
}
