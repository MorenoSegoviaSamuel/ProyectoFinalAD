package org.api.miprimeraapirest.controller;

import org.api.miprimeraapirest.model.Circuit;
import org.api.miprimeraapirest.service.CircuitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class CircuitRestController {

    private final CircuitService circuitService;

    @Autowired
    public CircuitRestController(CircuitService circuitService) {this.circuitService = circuitService;}

    @GetMapping("/circuits")
    public ResponseEntity<List<Circuit>> getAll(){
        return ResponseEntity.ok(circuitService.getAllCircuits());
    }

    @GetMapping("/circuits/{circuitRef}")
    public ResponseEntity<Circuit> getByConstructorRef(@PathVariable String circuitRef){
        return this.circuitService.getCircuitByCircuitRef(circuitRef)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/circuits")
    public ResponseEntity<Circuit> create(@RequestBody Circuit circuit){
        if(circuit.getCircuitId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(circuit);
    }

    @PutMapping("/circuits")
    public ResponseEntity<Circuit> update(@RequestBody Circuit circuit){
        this.circuitService.saveCircuit(circuit);
        return ResponseEntity.ok(circuit);
    }
}
