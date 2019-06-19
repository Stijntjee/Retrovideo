package be.vdab.retrovideo.services;

import be.vdab.retrovideo.domain.Reservatie;
import be.vdab.retrovideo.repositories.ReservatieRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
class DefaultReservatieService implements ReservatieService
{
    private final ReservatieRepository reservatieRepository;

    //CONSTRUCTORS
    DefaultReservatieService(ReservatieRepository reservatieRepository)
    {
        this.reservatieRepository = reservatieRepository;
    }

    //METHODS
    @Override
    public void create(Reservatie reservatie)
    {
        reservatieRepository.create(reservatie);
    }
}
