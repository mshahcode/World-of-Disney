package az.pashabank.cardzone.dao.repository;

import az.pashabank.cardzone.dao.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
