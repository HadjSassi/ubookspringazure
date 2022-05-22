package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;


import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.VoteDocument;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.VoteDocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoteDocumentService {

    private final VoteDocumentRepo voteDocumentRepo;

    @Autowired
    public VoteDocumentService(VoteDocumentRepo voteDocumentRepo) {
        this.voteDocumentRepo = voteDocumentRepo;
    }

    public VoteDocument addVoteDocument (VoteDocument voteDocument) {return voteDocumentRepo.save(voteDocument);}

    public List<VoteDocument> findAllVoteDocument () {return voteDocumentRepo.findAll();}

    public List<VoteDocument> findAllVoteDocumentByDocument (Long  document) {return voteDocumentRepo.findVoteDocumentsByDocument_IdDocument(document);}

    public VoteDocument findVoteDocumentById(Long id) {return voteDocumentRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Vote Document with the id = "+id+"was not found"));}

    public VoteDocument updateVoteDocument (VoteDocument voteDocument) {return voteDocumentRepo.save(voteDocument);}

    public void deleteVoteDocumentById (Long id) {this.voteDocumentRepo.deleteById(id);}

}
