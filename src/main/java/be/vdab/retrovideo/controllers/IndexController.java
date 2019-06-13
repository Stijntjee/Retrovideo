package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.domain.Genre;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
class IndexController
{
    private List<Genre> genres;
    private List<Film> films;
    FilmService filmService;

    IndexController(GenreService genreService, FilmService filmService)
    {
        genres = genreService.findAll();
        this.filmService = filmService;
    }

    //MAPPINGS
    @GetMapping("/")
    public ModelAndView index()
    {
        ModelAndView mav = new ModelAndView("index", "genres", genres);
        mav.addObject("genre", "");
        return mav;
    }

    @GetMapping("/{genre}")
    public ModelAndView getFilmsByGenre(@PathVariable("genre") String naam)
    {
        for (Genre genre : genres)
        {
            if (naam.equals(genre.getNaam()))
            {
                ModelAndView mav = new ModelAndView("index", "genres", genres);

                films = filmService.findByGenre(genre.getId());
                mav.addObject("films", films);
                mav.addObject("genre", naam);

                return mav;
            }
        }
        return index();
    }
}
