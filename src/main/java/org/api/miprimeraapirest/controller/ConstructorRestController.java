package org.api.miprimeraapirest.controller;

import jakarta.transaction.Transactional;
import org.api.miprimeraapirest.model.Constructor;
import org.api.miprimeraapirest.service.ConstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConstructorRestController {

    private final ConstructorService constructorService;

    @Autowired
    public ConstructorRestController(ConstructorService constructorService){
        this.constructorService = constructorService;
    }

    @GetMapping("/constructors")
    public ResponseEntity<List<Constructor>> getAll(
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size,
            @RequestParam(defaultValue = "constructorId") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection){
        Page<Constructor> listado = constructorService.getAllConstructorsPaged(page, size, sortBy, sortDirection);
        return ResponseEntity.ok(listado.getContent());
    }


    @GetMapping("/constructors/{constructorRef}")
    public ResponseEntity<Constructor> getByConstructorRef(@PathVariable String constructorRef){
        return this.constructorService.getConstructorByConstructorRef(constructorRef)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/constructors")
    public ResponseEntity<Constructor> create(@RequestBody Constructor constructor){
        if(constructor.getConstructorId() != null){
            return ResponseEntity.badRequest().build();
        }
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);
    }

    @PutMapping("/constructors")
    public ResponseEntity<Constructor> update(@RequestBody Constructor constructor){
        this.constructorService.saveConstructor(constructor);
        return ResponseEntity.ok(constructor);
    }

    @Transactional
    @DeleteMapping("/constructors/{constructorRef}")
    public ResponseEntity<Constructor> deleteByConstructorRef(@PathVariable String constructorRef){
        this.constructorService.deleteConstructorByConstructorRef(constructorRef);
        return ResponseEntity.ok().build();
    }
}
