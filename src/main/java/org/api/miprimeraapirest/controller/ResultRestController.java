package org.api.miprimeraapirest.controller;

import org.api.miprimeraapirest.model.Result;
import org.api.miprimeraapirest.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultRestController {

    private final ResultService resultService;

    @Autowired
    public ResultRestController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/results")
    public ResponseEntity<List<Result>> getAll(){
        return ResponseEntity.ok(resultService.getAllResults());
    }

    @GetMapping("/results/{raceId}")
    public ResponseEntity<Result> getByRaceId(Long raceId){
        return this.resultService.findByRaceId(raceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
