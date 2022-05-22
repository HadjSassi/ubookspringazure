package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.CommentDocument;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.CommentDocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentDocumentService {

    private final CommentDocumentRepo commentDocumentRepo;

    @Autowired

    public CommentDocumentService(CommentDocumentRepo commentDocumentRepo) {
        this.commentDocumentRepo = commentDocumentRepo;
    }

    public CommentDocument addCommentDocument (CommentDocument commentDocument) {return this.commentDocumentRepo.save(commentDocument);}

    public List<CommentDocument> findAllCommentDocument () {return this.commentDocumentRepo.findAll();}

    public List<CommentDocument> findAllCommentDocumentByDocument (Long document) {return this.commentDocumentRepo.findAllByDocument_IdDocument(document);}

    public CommentDocument findCommentDocumentById (Long id) {return this.commentDocumentRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Comment Document with the id = "+id+"was not found"));}

    public CommentDocument updateCommentDocument(CommentDocument commentDocument) {return this.commentDocumentRepo.save(commentDocument);}

    public void deleteCommentDocumentById (Long id){this.commentDocumentRepo.deleteById(id);}

}
