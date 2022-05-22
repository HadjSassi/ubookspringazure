package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.VoteDocument;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoteDocumentRepo extends JpaRepository<VoteDocument,Long> {
    List<VoteDocument> findVoteDocumentsByDocument_IdDocument (Long  document);
}
