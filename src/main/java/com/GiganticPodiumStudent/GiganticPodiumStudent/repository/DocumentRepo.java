package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepo extends JpaRepository<Document,Long> {
}
