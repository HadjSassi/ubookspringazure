package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;


import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.CommentDocumentService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.CommentDocument;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment_document")
public class CommentDocumentCtrl {

    private final CommentDocumentService commentDocumentService;

    public CommentDocumentCtrl(CommentDocumentService commentDocumentService) {
        this.commentDocumentService = commentDocumentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<CommentDocument>> getAllCommentDocument (){
        List<CommentDocument> commentDocument=  this.commentDocumentService.findAllCommentDocument();
        return new ResponseEntity<>(commentDocument, HttpStatus.OK);
    }

    @GetMapping("/allForOne/{id}")
    public ResponseEntity<List<CommentDocument>> getAllCommentDocumentByDocument (@PathVariable("id") Long id){
        List<CommentDocument> commentDocument=  this.commentDocumentService.findAllCommentDocumentByDocument(id);
        return new ResponseEntity<>(commentDocument, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CommentDocument> getCommentDocumentById (@PathVariable("id") Long id){
        CommentDocument commentDocument=  this.commentDocumentService.findCommentDocumentById(id);
        return new ResponseEntity<>(commentDocument, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<CommentDocument> addCommentDocument (@RequestBody CommentDocument commentDocument){
        CommentDocument newCommentDocument=  this.commentDocumentService.addCommentDocument(commentDocument);
        return new ResponseEntity<>(newCommentDocument, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CommentDocument> updateCommentDocument (@RequestBody CommentDocument commentDocument){
        CommentDocument updateComentDocument=  this.commentDocumentService.updateCommentDocument(commentDocument);
        return new ResponseEntity<>(updateComentDocument, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCommentDocumentById (@PathVariable("id") Long id){
        this.commentDocumentService.deleteCommentDocumentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}