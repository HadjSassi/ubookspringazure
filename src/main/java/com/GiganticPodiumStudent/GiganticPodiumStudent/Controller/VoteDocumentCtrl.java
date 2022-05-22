package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.VoteDocumentService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.VoteDocument;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote_document")
public class VoteDocumentCtrl {

    private final VoteDocumentService voteDocumentService;

    public VoteDocumentCtrl(VoteDocumentService voteDocumentService) {
        this.voteDocumentService = voteDocumentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<VoteDocument>> getAllVoteDocument (){
        List<VoteDocument> voteDocument=  this.voteDocumentService.findAllVoteDocument();
        return new ResponseEntity<>(voteDocument, HttpStatus.OK);
    }

    @GetMapping("/allForOne/{id}")
    public ResponseEntity<List<VoteDocument>> getAllVoteDocumentByDocument (@PathVariable("id")Long id){
        List<VoteDocument> voteDocument=  this.voteDocumentService.findAllVoteDocumentByDocument(id);
        return new ResponseEntity<>(voteDocument, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<VoteDocument> getVoteDocumentById (@PathVariable("id") Long id){
        VoteDocument voteDocument=  this.voteDocumentService.findVoteDocumentById(id);
        return new ResponseEntity<>(voteDocument, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<VoteDocument> addVoteDocument (@RequestBody VoteDocument voteDocument){
        VoteDocument newVoteDocument=  this.voteDocumentService.addVoteDocument(voteDocument);
        return new ResponseEntity<>(newVoteDocument, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<VoteDocument> updateVoteDocument (@RequestBody VoteDocument voteDocument){
        VoteDocument newvoteDocument =  this.voteDocumentService.updateVoteDocument(voteDocument);
        return new ResponseEntity<>(newvoteDocument, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVoteDocumentById (@PathVariable("id") Long id){
        this.voteDocumentService.deleteVoteDocumentById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}