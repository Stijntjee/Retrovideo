package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @GetMapping("{id}/mandje")
    public ModelAndView ganaarMandje(@PathVariable("id") int id)
    {
        voegToe(id);
        List<Film> alleFilms = filmService.findAll();

        ModelAndView mav = new ModelAndView("mandje").addObject("mandje", alleFilms);

        if (mandje.isGevuld()) {
            mav.addObject("filmsInMandje", alleFilms.stream().filter(film ->
                    mandje.bevat(film.getId())).collect(Collectors.toList()));

        }

        return mav;
    }

    public @PostMapping
    String voegToe(int id)
    {
        mandje.voegToe(id);
        return "redirect:/mandje";
    }

    }
