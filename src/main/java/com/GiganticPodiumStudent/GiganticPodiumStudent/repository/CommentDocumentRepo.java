package com.GiganticPodiumStudent.GiganticPodiumStudent.repository;

import com.GiganticPodiumStudent.GiganticPodiumStudent.model.CommentDocument;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDocumentRepo extends JpaRepository<CommentDocument,Long> {
    List<CommentDocument> findAllByDocument_IdDocument(Long document);
}