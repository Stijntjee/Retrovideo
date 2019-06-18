package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/mandjes")
public class MandjeController
{
    private final Mandje mandje;
    private final FilmService filmservice;

    MandjeController(Mandje mandje, FilmService filmService)
    {
        this.mandje = mandje;
        this.filmservice = filmService;
    }

    @GetMapping
    public ModelAndView mandje()
    {
        voegToe(1);
        voegToe(3);
        /*List<Film> alleFilms = filmservice.findAll();
        ModelAndView mav = new ModelAndView("mandje").addObject("mandje", alleFilms);
        if (mandje.isGevuld()) {
            mav.addObject("filmsInMandje", alleFilms.stream().filter(film ->
                    mandje.bevat(film.getId())).collect(Collectors.toList()));*/

        return new ModelAndView("index","index","kip");
    }

    public @PostMapping
    String voegToe(int id)
    {
        mandje.voegToe(id);
        return "redirect:/mandje";
    }

}
