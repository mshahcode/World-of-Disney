package az.pashabank.cardzone.dao.repository;

import az.pashabank.cardzone.dao.entity.Character;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character,Long> {
    @Query(value = "SELECT c FROM Character c JOIN c.movies m where m.id = :movieId")
    Page<Character> getCharactersByMovieId(@Param("movieId") Long movieId, Pageable pageable);

    @Query(value = "SELECT c FROM Character c WHERE c.name = :name")
    Page<Character> getCharactersByName(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT c FROM Character c WHERE c.age = :age")
    Page<Character> getCharactersByAge(@Param("age") Short age, Pageable pageable);
}
