package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Document implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long idDocument ;
    private String nomDocument;
    @Enumerated(value = EnumType.STRING)
    private DocumentType typeDocument;
    @ManyToOne
    private Settings settings;
    private String descriptionDocument;
    @Column (columnDefinition="text")
    private String creative;
    private String urlDocument;
    private String documentAssoscie;
    private String afficheDocument;
    private String veracity;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(columnDefinition = "varchar(100)",nullable = false, name = "uid")
    private User uid ;

    public Document() { }

    public Long getIdDocument() {
        return idDocument;
    }

    public void setIdDocument(Long idDocument) {
        this.idDocument = idDocument;
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        this.nomDocument = nomDocument;
    }

    public DocumentType getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(DocumentType typeDocument) {
        this.typeDocument = typeDocument;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setSettings(Settings settings) {
        this.settings = settings;
    }

    public String getDescriptionDocument() {
        return descriptionDocument;
    }

    public void setDescriptionDocument(String descriptionDocument) {
        this.descriptionDocument = descriptionDocument;
    }

    public String getUrlDocument() {
        return urlDocument;
    }

    public void setUrlDocument(String urlDocument) {
        this.urlDocument = urlDocument;
    }

    public String getDocumentAssoscie() {
        return documentAssoscie;
    }

    public void setDocumentAssoscie(String documentAssoscie) {
        this.documentAssoscie = documentAssoscie;
    }

    public String getAfficheDocument() {
        return afficheDocument;
    }

    public void setAfficheDocument(String afficheDocument) {
        this.afficheDocument = afficheDocument;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public String getCreative() {
        return creative;
    }

    public void setCreative(String creative) {
        this.creative = creative;
    }

    public String getVeracity() {
        return veracity;
    }

    public void setVeracity(String veracity) {
        this.veracity = veracity;
    }

    @Override
    public String toString() {
        return "Document{" +
                "idDocument=" + idDocument +
                ", nomDocument='" + nomDocument + '\'' +
                ", typeDocument=" + typeDocument +
                ", settings=" + settings +
                ", descriptionDocument='" + descriptionDocument + '\'' +
                ", creativeCommos='" + creative + '\'' +
                ", urlDocument='" + urlDocument + '\'' +
                ", veracity='" + veracity + '\'' +
                ", documentAssoscie='" + documentAssoscie + '\'' +
                ", afficheDocument='" + afficheDocument + '\'' +
                ", uid=" + uid +
                '}';
    }
}
