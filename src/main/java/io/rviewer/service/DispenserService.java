package io.rviewer.service;

import io.rviewer.domain.Dispenser;
import io.rviewer.domain.dto.DispenserDto;
import io.rviewer.domain.dto.DispenserStatusDTO;

import java.util.UUID;

public interface DispenserService {

    DispenserDto createNewDispenser(DispenserDto dispenserDto);

    DispenserDto addDispenserUsage(UUID uuid);

    Dispenser getDispenser(String dispenserId);

    void updateDispenserStatusAndUsage(DispenserStatusDTO statusDTO, Dispenser dispenser);
}
