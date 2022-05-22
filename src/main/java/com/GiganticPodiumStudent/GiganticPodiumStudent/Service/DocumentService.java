package com.GiganticPodiumStudent.GiganticPodiumStudent.Service;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Config;
import com.GiganticPodiumStudent.GiganticPodiumStudent.Exception.UserNotFoundException;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import com.GiganticPodiumStudent.GiganticPodiumStudent.repository.DocumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class DocumentService {

    private final String path = Config.path+"../../";

    private final DocumentRepo documentRepo ;

    @Autowired
    public DocumentService(DocumentRepo documentRepo) {
        this.documentRepo = documentRepo;
    }

    public Document addDocument (Document document){ return documentRepo.save(document); }

    public List<Document> findAllDocument(){return documentRepo.findAll();}

    public Document findDocumentById(Long id){ return documentRepo.findById(id).orElseThrow(() -> new UserNotFoundException("Document with the id = " + id + " was not found")); }


    public Document updateDocument(Document document){ return documentRepo.save(document); }

    public void deleteDocument (Long Id) throws IOException {
        Document doc = documentRepo.findById(Id).orElseThrow(() -> new UserNotFoundException("Document with the id = " + Id + " was not found"));
        Path fileToDeletePath = Paths.get(path+doc.getUrlDocument());
        Files.delete(fileToDeletePath);
        this.documentRepo.deleteById(Id);
    }

    public void resetUrl (Long Id) throws IOException {
        Document doc = documentRepo.findById(Id).orElseThrow(() -> new UserNotFoundException("Document with the id = " + Id + " was not found"));
        Path fileToDeletePath = Paths.get(path+doc.getUrlDocument());
        Files.delete(fileToDeletePath);
    }



}


