package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;


import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.CentreFormationService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.CentreFormation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/CentreFormation")
public class CentreFormationCtrl {

    private final CentreFormationService CentreFormationService;

    public CentreFormationCtrl(CentreFormationService CentreFormationService) {
        this.CentreFormationService = CentreFormationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CentreFormation>> getAllCentreFormations() {
        List<CentreFormation> CentreFormations = this.CentreFormationService.findAllCentreFormation();
        return new ResponseEntity<>(CentreFormations, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<CentreFormation> getCentreFormationById(@PathVariable("id") Long id) {
        CentreFormation CentreFormation = this.CentreFormationService.findCentreFormationById(id);
        return new ResponseEntity<>(CentreFormation, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CentreFormation> addCentreFormation(@RequestBody CentreFormation CentreFormation) {
        CentreFormation newCentreFormation = this.CentreFormationService.addCentreFormation(CentreFormation);
        return new ResponseEntity<>(newCentreFormation, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<CentreFormation> updateCentreFormation(@RequestBody CentreFormation CentreFormation) {
        CentreFormation updateCentreFormation = this.CentreFormationService.updateCentreFormation(CentreFormation);
        return new ResponseEntity<>(updateCentreFormation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCentreFormationById(@PathVariable("id") Long id) {
        this.CentreFormationService.deleteCentreFormation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}