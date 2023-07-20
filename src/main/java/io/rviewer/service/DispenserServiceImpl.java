package io.rviewer.service;

import io.rviewer.domain.Dispenser;
import io.rviewer.domain.Status;
import io.rviewer.domain.dto.DispenserDto;
import io.rviewer.exception.DispenserServiceException;
import io.rviewer.repo.DispenserRepository;
import org.springframework.stereotype.Service;

@Service
public class DispenserServiceImpl implements DispenserService{

    private final DispenserRepository dispenserRepository;

    public DispenserServiceImpl(DispenserRepository dispenserRepository) {
        this.dispenserRepository = dispenserRepository;
    }

    @Override
    public DispenserDto createNewDispenser(DispenserDto dispenserDto)
    {

        if( dispenserDto == null)
        {
            throw new DispenserServiceException("Invalid Operation. Null Values Cannot Be Set For A New Dispenser");
        }

        Dispenser newDispenser = new Dispenser();
        newDispenser.setFlowVolume(dispenserDto.getFlowVolume());
        newDispenser.setStatus(Status.close);

        newDispenser = this.dispenserRepository.save(newDispenser);

        dispenserDto.setFlowVolume(newDispenser.getFlowVolume());

        return dispenserDto;
    }
}
