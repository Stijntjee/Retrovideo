package be.vdab.retrovideo.controllers;

import be.vdab.retrovideo.domain.Film;
import be.vdab.retrovideo.domain.Klant;
import be.vdab.retrovideo.domain.Reservatie;
import be.vdab.retrovideo.services.FilmService;
import be.vdab.retrovideo.services.KlantService;
import be.vdab.retrovideo.services.ReservatieService;
import be.vdab.retrovideo.sessions.Mandje;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bevestigen")
class BevestigenController {
    private List<Klant> klanten;
    KlantService klantService;
    FilmService filmService;
    ReservatieService reservatieService;
    Optional<Klant> klant;
    Mandje mandje;

    //CONSTRUCTORS
    public BevestigenController
    (KlantService klantService, Mandje mandje, ReservatieService reservatieService, FilmService filmService) {
        this.klantService = klantService;
        this.mandje = mandje;
        this.reservatieService = reservatieService;
        this.filmService = filmService;
    }

    //MAPPINGS
    @GetMapping()
    public ModelAndView bevestigen() {
        ModelAndView mav = new ModelAndView("bevestigen");
        return mav;
    }

    @GetMapping("/{id}")
    public ModelAndView bevestigen(@PathVariable("id") int id)
    {
        int aantal = mandje.getIds().size();
        ModelAndView mav = new ModelAndView("bevestigen");
        mav.addObject("aantal", aantal);

        klant = klantService.getKlantById(id);
        klantService.getKlantById(id).ifPresent(klant -> {
            mav.addObject("klant", klant);
        });
        reserveer(id);
        return mav;
    }

    public void reserveer(int klantid)
    {
        for (int i : mandje.getIds()) {
            Reservatie reservatie = new Reservatie(klantid, i, LocalDateTime.now());
            filmService.getFilmById(i).ifPresent(film -> filmService.reserveer(film));
            reservatieService.create(reservatie);
        }
    }
}
