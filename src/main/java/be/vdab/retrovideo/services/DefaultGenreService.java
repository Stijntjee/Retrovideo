package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Genre;
import be.vdab.retrovideo.repositories.GenreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true , isolation = Isolation.READ_COMMITTED)
class DefaultGenreService implements GenreService
{
    private final GenreRepository genreRepository;

    //CONSTRUCTORS
    DefaultGenreService(GenreRepository genreRepository)
    {
        this.genreRepository = genreRepository;
    }

    //METHODS
    @Override
    public List<Genre> findAll()
    {
        return genreRepository.findAll();
    }
}
