package io.rviewer.rest;

import io.rviewer.domain.Dispenser;
import io.rviewer.domain.DispenserStatusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("beer-tap-dispenser")
public class BeerTapDispenserController {

    private static Map<Integer, Dispenser> dispenserMap = new HashMap<>();

    @PostMapping("/dispenser/{id}/status")
    public ResponseEntity<?> createDispenser(@RequestBody DispenserStatusDTO  dispenserStatusDTO){
        ResponseEntity responseEntity = ResponseEntity.ok(HttpStatus.CREATED);
        return responseEntity;
    }

    @PutMapping("/dispenser/{id}/status")
    public ResponseEntity<?> changeDispenserState(@PathVariable() String id)
    {
        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.ACCEPTED);

        return responseEntity;
    }

    @GetMapping("/dispenser/{id}/spending")
    public ResponseEntity<?> dispenserUsages(@PathVariable() String id)
    {
        ResponseEntity responseEntity = new ResponseEntity<>(HttpStatus.OK);

        return responseEntity;
    }
}
