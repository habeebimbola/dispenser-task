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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("beer-tap-dispenser")
public class BeerTapDispenserController {

    private static Map<Integer, Dispenser> dispenserMap = new HashMap<>();

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

        if (dispenserStatusDTO.getStatus() == Status.OPEN)
        {
            dispenserMap.put(null,null);
        }

        if (dispenserStatusDTO.getStatus() == Status.CLOSE)
        {

        }
        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);

        return ResponseEntity.accepted().build();
    }

    @GetMapping("/dispenser/{id}/spending")
    public ResponseEntity<?> dispenserUsages(@PathVariable("id") String dispenserId)
    {
        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);

        return ResponseEntity.ok().build();
    }
}
