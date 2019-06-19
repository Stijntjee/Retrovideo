package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Klant;

import java.util.List;
import java.util.Optional;

public interface KlantRepository
{
    List<Klant> getKlantByFamilieNaam(String familienaam);
    Optional<Klant> getKlantById(int id);
}
