package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;


import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.InstitusService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Institus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/institus")
public class InstitusCtrl {

    private final InstitusService InstitusService;

    public InstitusCtrl(InstitusService InstitusService) {
        this.InstitusService = InstitusService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Institus>> getAllInstituss() {
        List<Institus> Instituss = this.InstitusService.findAllInstitus();
        return new ResponseEntity<>(Instituss, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Institus> getInstitusById(@PathVariable("id") Long id) {
        Institus Institus = this.InstitusService.findInstitusById(id);
        return new ResponseEntity<>(Institus, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Institus> addInstitus(@RequestBody Institus Institus) {
        Institus newInstitus = this.InstitusService.addInstitus(Institus);
        return new ResponseEntity<>(newInstitus, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Institus> updateInstitus(@RequestBody Institus Institus) {
        Institus updateInstitus = this.InstitusService.updateInstitus(Institus);
        return new ResponseEntity<>(updateInstitus, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInstitusById(@PathVariable("id") Long id) {
        this.InstitusService.deleteInstitus(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}