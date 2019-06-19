package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Klant;

import java.util.List;
import java.util.Optional;

public interface KlantService
{
    List<Klant> getKlantByFamilieNaam(String familienaam);
    Optional<Klant> getKlantById(int id);
}
