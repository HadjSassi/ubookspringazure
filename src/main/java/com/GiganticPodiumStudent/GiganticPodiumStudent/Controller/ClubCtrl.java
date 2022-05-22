package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.ClubService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Club;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/club")
public class ClubCtrl {

    private final ClubService clubService ;

    public ClubCtrl(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Club>> getAllClubs(){
        List<Club> clubs = this.clubService.findAllClub();
        return new ResponseEntity<>(clubs, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Club> getClubById (@PathVariable("id") Long id){
        Club club=  this.clubService.findClubById(id);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Club> addClub (@RequestBody Club club){
        Club newClub=  this.clubService.addClub(club);
        return new ResponseEntity<>(newClub, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Club> updateClub (@RequestBody Club Club){
        Club updateClub=  this.clubService.updateClub(Club);
        return new ResponseEntity<>(updateClub, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClubById (@PathVariable("id") Long id){
        this.clubService.deleteClub(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
