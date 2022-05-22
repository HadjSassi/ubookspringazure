package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CommentDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComment;

    private String comment ;

    @ManyToOne(targetEntity = Document.class)
    @JoinColumn(nullable = false)
    private Document document;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(columnDefinition = "varchar(100)",nullable = false, name = "uid")
    private User  user;

    private String timing ;

    public CommentDocument() {
    }

    public Long getIdComment() {
        return idComment;
    }

    public void setIdComment(Long idComment) {
        this.idComment = idComment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    @Override
    public String toString() {
        return "CommentDocument{" +
                "idComment=" + idComment +
                ", comment='" + comment + '\'' +
                ", document=" + document +
                ", user=" + user +
                ", timing='" + timing + '\'' +
                '}';
    }
}

