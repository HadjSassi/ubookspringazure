package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.EventService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Event;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.EventType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Event")
public class EventCtrl {

    private final EventService EventService;

    public EventCtrl(EventService EventService) {
        this.EventService = EventService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvent() {
        List<Event> events = this.EventService.findAllEvent();
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/Certification")
    public ResponseEntity<List<Event>> getAllCertification() {
        List<Event> events = this.EventService.findAllEventByType(EventType.Certification);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/Competition")
    public ResponseEntity<List<Event>> getAllCompetition() {
        List<Event> events = this.EventService.findAllEventByType(EventType.Competition);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }

    @GetMapping("/Formation")
    public ResponseEntity<List<Event>> getAllFormation() {
        List<Event> events = this.EventService.findAllEventByType(EventType.Formation);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }
    @GetMapping("/Journey")
    public ResponseEntity<List<Event>> getAllJourney() {
        List<Event> events = this.EventService.findAllEventByType(EventType.Journey);
        return new ResponseEntity<>(events, HttpStatus.OK);
    }


    @GetMapping("/find/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Long id) {
        Event Event = this.EventService.findEventById(id);
        return new ResponseEntity<>(Event, HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Event> addEvent(@RequestBody Event Event) {
        Event newEvent = this.EventService.addEvent(Event);
        return new ResponseEntity<>(newEvent, HttpStatus.CREATED);
    }


    @PutMapping("/update")
    public ResponseEntity<Event> updateEvent(@RequestBody Event Event) {
        Event updateEvent = this.EventService.updateEvent(Event);
        return new ResponseEntity<>(updateEvent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEventById(@PathVariable("id") Long id) {
        try {
            this.EventService.deleteEvent(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/deleteAffiche/{id}")
    public ResponseEntity<?> resetAffiche(@PathVariable("id") Long id) {
        try {
            this.EventService.reseetAffiche(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}