package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Event;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepo extends JpaRepository<Event, Long> {
    List<Event> findAllByType(EventType type);
}