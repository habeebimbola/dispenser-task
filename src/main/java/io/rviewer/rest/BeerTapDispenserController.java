package io.rviewer.rest;

import io.rviewer.domain.Dispenser;
import io.rviewer.domain.dto.DispenserDto;
import io.rviewer.domain.dto.DispenserStatusDTO;
import io.rviewer.rest.validator.DispenserValidatorBuilder;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("beer-tap-dispenser")
public class BeerTapDispenserController {

    private static Map<Integer, Dispenser> dispenserMap = new HashMap<>();

    @PostMapping("/dispenser/{id}/create")
    public ResponseEntity<?> createDispenser(@Valid() @RequestBody DispenserDto dispenserDto, BindingResult bindingResult){

        if(bindingResult.hasErrors())
        {
            return ResponseEntity.badRequest().body(DispenserValidatorBuilder.fromBindingErrors(bindingResult));
        }

        ResponseEntity responseEntity = ResponseEntity.status(202).build();
        return responseEntity;
    }

    @PutMapping("/dispenser/{id}/status")
    public ResponseEntity<?> changeDispenserState(@PathVariable("id") String dispenserId)
    {
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
