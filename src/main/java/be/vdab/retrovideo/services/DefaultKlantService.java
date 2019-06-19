package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Klant;
import be.vdab.retrovideo.repositories.KlantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true , isolation = Isolation.READ_COMMITTED)
class DefaultKlantService implements KlantService
{
    private final KlantRepository klantRepository;

    //CONSTRUCTORS
    DefaultKlantService(KlantRepository klantRepository)
    {
        this.klantRepository = klantRepository;
    }

    //METHODS
    @Override
    public List<Klant> getKlantByFamilieNaam(String familienaam) {
        return klantRepository.getKlantByFamilieNaam(familienaam);
    }

    @Override
    public Optional<Klant> getKlantById(int id) {
        return klantRepository.getKlantById(id);
    }
}
