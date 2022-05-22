package com.GiganticPodiumStudent.GiganticPodiumStudent.Controller;

import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.DocumentService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.Service.EmailSenderService;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.Document;
import com.GiganticPodiumStudent.GiganticPodiumStudent.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/document")
public class DocumentCtrl {

    private final DocumentService documentService;

    private final EmailSenderService emailSenderService;

    public DocumentCtrl(DocumentService DocumentService, EmailSenderService emailSenderService) {
        this.documentService = DocumentService;
        this.emailSenderService = emailSenderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Document>> getAllDocument() {
        List<Document> Documents = this.documentService.findAllDocument();
        return new ResponseEntity<>(Documents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable("id") Long id) {
        Document Document = this.documentService.findDocumentById(id);
        return new ResponseEntity<>(Document, HttpStatus.OK);
    }


    @PutMapping("/update")
    public ResponseEntity<Document> updateDocument(@RequestBody Document document) {
        Document updateDocument = this.documentService.updateDocument(document);
        return new ResponseEntity<>(updateDocument, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteDocumentById(@PathVariable("id") Long id) {
        try {
            this.documentService.deleteDocument(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteUrl/{id}")
    public ResponseEntity<?> resetUrl(@PathVariable("id") Long id) {
        try {
            this.documentService.resetUrl(id);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<Document> addDocument(@RequestBody Document Document) {
        Document newDocument = this.documentService.addDocument(Document);
//        this.verifyingVeracity(newDocument);
        new Thread(() -> { this.verifyingVeracity(newDocument); }).start();
        return new ResponseEntity<>(newDocument, HttpStatus.CREATED);
    }

    public void verifyingVeracity(Document document) {
        User user = document.getUid();
        String paath = "C:/Users/Hadj Sassi/Desktop/Mahdi/ubook/src/";
        try {
            String creative = "ççç^&é((''²²²]]]))°°)";
            if (document.getCreative().length() != 0) {
                creative = document.getCreative().replace(" ", "");
            }
            ProcessBuilder builder = new ProcessBuilder("python",
                    "src/main/java/Python/__init__.py",
                    paath + document.getUrlDocument(), document.getNomDocument()
                    , document.getSettings().getMatiere(), document.getSettings().getAnnee(), creative);
            Process process = builder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String authoring = reader.readLine();
            String yearing = reader.readLine();
            String subjecting = reader.readLine();
            if (authoring.equals("Author Confirmed") && yearing.equals("Year Confirmed") && subjecting.equals("Subject Confirmed")) {
                this.emailSenderService.DocumentVeracityTrue(user,document);
                document.setVeracity("Confirmed");
            } else {
               this.emailSenderService.DocumentVeracityFalse(user,document,subjecting,authoring,yearing);
                document.setVeracity("Not Confrimed");
            }
            this.documentService.updateDocument(document);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}


