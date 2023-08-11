package io.rviewer.service;

import io.rviewer.domain.Dispenser;
import io.rviewer.domain.DispenserUsage;
import io.rviewer.domain.Status;
import io.rviewer.domain.dto.DispenserDto;
import io.rviewer.domain.dto.DispenserStatusDTO;
import io.rviewer.exception.DispenserServiceException;
import io.rviewer.repo.DispenserRepository;
import io.rviewer.repo.DispenserUsageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class DispenserServiceImpl implements DispenserService{

    @Value("${flow.costPerLitre}")
    private Double costPerLitre;

    private final DispenserRepository dispenserRepository;
    private final DispenserUsageRepository dispenserUsageRepository;

    public DispenserServiceImpl(DispenserRepository dispenserRepository, DispenserUsageRepository dispenserUsageRepository) {
        this.dispenserRepository = dispenserRepository;
        this.dispenserUsageRepository = dispenserUsageRepository;
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
        newDispenser.setStatus(Status.CLOSE);

        newDispenser = this.dispenserRepository.save(newDispenser);

        dispenserDto.setFlowVolume(newDispenser.getFlowVolume());
        dispenserDto.setUuid(newDispenser.getUuid());

        return dispenserDto;
    }

    @Override
    public DispenserDto addDispenserUsage(UUID dispenserId)
    {

        Dispenser dispenser = this.dispenserRepository.getReferenceById(dispenserId);

        DispenserUsage dispenserUsage = new DispenserUsage();
        dispenserUsage.setDispenser(dispenser);
        DispenserUsage createdDispenserUsage = this.dispenserUsageRepository.save(dispenserUsage);

        DispenserDto dispenserDto = new DispenserDto();
        dispenserDto.setFlowVolume(createdDispenserUsage.getDispenser().getFlowVolume());
        dispenserDto.setUuid(createdDispenserUsage.getDispenser().getUuid());

        return dispenserDto;
    }

    @Override
    public Dispenser getDispenser(String dispenserId) {

        if(dispenserId == null )
        {
            throw new DispenserServiceException("Dispenser ID Cannot Be Null/Empty");
        }

        Optional<Dispenser> dispenserOptional = this.dispenserRepository.findById(UUID.fromString( dispenserId.trim()));

        if (dispenserOptional.isEmpty())
        {
            return dispenserOptional.orElse(new Dispenser());
        }

        return dispenserOptional.get();
    }

    @Override
    public void updateDispenserStatusAndUsage(DispenserStatusDTO statusDTO, Dispenser dispenser) {

//        LocalDateTime.parse(statusDTO.getUpdatedTime()) ;

        dispenser.setStatus(statusDTO.getStatus());
        Dispenser updatedDispenser = this.dispenserRepository.save(dispenser);

        this.addDispenserUsage(updatedDispenser.getUuid());

    }
}
