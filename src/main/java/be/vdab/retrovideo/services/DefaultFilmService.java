package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.repositories.FilmRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
class DefaultFilmService implements FilmService
{

    private final FilmRepository filmRepository;

    //CONSTRUCTORS
    DefaultFilmService(FilmRepository filmRepository)
    {
        this.filmRepository = filmRepository;
    }

    //METHODS
    @Override
    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    @Override
    public List<Film> findByGenre(int genreid) {
        return filmRepository.findByGenre(genreid);
    }

    @Override
    public Optional<Film> getFilmById(int id)
    {
        return filmRepository.getFilmById(id);
    }

    @Override
    public void reserveer(Film film) {
        filmRepository.reserveer(film);
    }
}
