package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Klant;

import java.util.List;

public interface KlantService
{

    List<Klant> getKlantByFamilieNaam(String familienaam);
}
