package be.vdab.retrovideo.repositories;

import be.vdab.retrovideo.domain.Klant;

import java.util.List;

public interface KlantRepository
{
    List<Klant> getKlantByFamilieNaam(String familienaam);

}
