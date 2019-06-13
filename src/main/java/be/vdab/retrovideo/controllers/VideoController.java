package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.GenreService;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/video")
class VideoController
{
    FilmService filmService;
    Mandje mandje;
    Optional<Film> film;

    VideoController(FilmService filmService, Mandje mandje)
    {
        this.filmService = filmService;
        this.mandje = mandje;
    }


    @GetMapping
    public ModelAndView video()
    {
        String boodschap = "hello world";
        return  new ModelAndView("video", "boodschap", boodschap);
    }

    @GetMapping("{id}")
    public ModelAndView getFilmsByGenre(@PathVariable("id") int id)
    {
        ModelAndView mav = new ModelAndView("video");
        film = filmService.getFilmById(id);

        filmService.getFilmById(id).ifPresent(film -> { mav.addObject("film", film);});
        return mav;
    }

    }
