package io.rviewer.rest;

import io.rviewer.domain.Dispenser;
import io.rviewer.domain.Status;
import io.rviewer.domain.dto.DispenserDto;
import io.rviewer.domain.dto.DispenserStatusDTO;
import io.rviewer.rest.validator.DispenserValidatorBuilder;
import io.rviewer.service.DispenserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("beer-tap-dispenser")
public class BeerTapDispenserController {

    @Autowired
    private DispenserService dispenserService;

    @PostMapping("/dispenser/create")
    public ResponseEntity<?> createDispenser(@Valid() @RequestBody DispenserDto dispenserDto, BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body(DispenserValidatorBuilder.fromBindingErrors(bindingResult));
        }

        DispenserDto createdDispenserDto = this.dispenserService.createNewDispenser(dispenserDto);

//        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdDispenserDto.getUuid()).toUri();

        ResponseEntity responseEntity = ResponseEntity.status(202).body(createdDispenserDto);
        return responseEntity;
    }

    @PutMapping("/dispenser/{id}/status")
    public ResponseEntity<?> changeDispenserStatus(@PathVariable("id") String dispenserId, @Valid() @RequestBody() DispenserStatusDTO dispenserStatusDTO, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body(DispenserValidatorBuilder.fromBindingErrors(bindingResult));
        }

        Dispenser dispenser = this.dispenserService.getDispenser(dispenserId);

        if( dispenser.getUuid() == null)
        {
            return ResponseEntity.notFound().build();
        }

        Status dtoStatus = dispenserStatusDTO.getStatus();

        if(( dtoStatus == Status.OPEN && dispenser.getStatus() == Status.OPEN) || (dtoStatus == Status.CLOSE && dispenser.getStatus() == Status.CLOSE ))
        {
            return ResponseEntity.status(409).body("Dispenser is already Opened/Closed");
        }

        if (dispenserStatusDTO.getStatus() == Status.OPEN && dispenser.getStatus() == Status.CLOSE)
        {
            this.dispenserService.updateDispenserStatusAndUsage(dispenserStatusDTO, dispenser);
        }


        if (dispenserStatusDTO.getStatus() == Status.CLOSE && dispenser.getStatus() == Status.OPEN)
        {
            this.dispenserService.updateDispenserStatusAndUsage(dispenserStatusDTO, dispenser);
        }


        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/dispenser/{id}/spending")
    public ResponseEntity<?> dispenserUsages(@PathVariable("id") String dispenserId)
    {
        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);

        return ResponseEntity.ok().build();
    }
}
