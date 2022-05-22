package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.Config;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Event;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.EventType;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class EventService {
    private final String path = Config.path+"../../";
    private final EventRepo EventRepo;

    @Autowired
    public EventService(EventRepo eventRepo) {
        this.EventRepo = eventRepo;
    }

    public Event addEvent(Event Event) {
        return this.EventRepo.save(Event);
    }

    public List<Event> findAllEvent() {
        return EventRepo.findAll();
    }

    public List<Event> findAllEventByType(EventType eventType) {
        return EventRepo.findAllByType(eventType);
    }

    public Event findEventById(Long id) {
        return EventRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Event with the id = " + id + " was not found"));
    }

    public Event updateEvent(Event Event) {
        return EventRepo.save(Event);
    }

    public void deleteEvent(Long id) throws IOException {
        Event event = EventRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Event with the id = " + id + " was not found"));
        Path fileToDeletePath = Paths.get(path + event.getAffiche());
        Files.delete(fileToDeletePath);
        this.EventRepo.deleteById(id);
    }

    public void reseetAffiche(Long id) throws IOException {
        Event event = EventRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Event with the id = " + id + " was not found"));
        Path fileToDeletePath = Paths.get(path + event.getAffiche());
        Files.delete(fileToDeletePath);
    }
}