package az.pashabank.cardzone.service;

import az.pashabank.cardzone.dao.entity.Genre;
import az.pashabank.cardzone.dao.entity.Image;
import az.pashabank.cardzone.dao.repository.GenreRepository;
import az.pashabank.cardzone.mapper.GenreMapper;
import az.pashabank.cardzone.model.dto.genre.UpdatedGenreDTO;
import az.pashabank.cardzone.utils.ImageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public UpdatedGenreDTO addGenre(String name, MultipartFile imageFile) throws IOException {
        Genre genre = new Genre();
        genre.setName(name);
        Image image = ImageUtil.saveImageToLocalSystem(imageFile);
        genre.setImage(image);
        return GenreMapper.INSTANCE.mapGenreToUpdatedGenre(genreRepository.save(genre));
    }
}
