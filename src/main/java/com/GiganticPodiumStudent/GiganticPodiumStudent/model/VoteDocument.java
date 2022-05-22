package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;

@Entity
public class VoteDocument implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long voteId;

    private int voteType ;
    @ManyToOne(targetEntity = Document.class)
    @JoinColumn(nullable = false)
    private Document document;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(columnDefinition = "varchar(100)",nullable = false, name = "uid")
    private User user;

    public VoteDocument() {
    }

    public VoteDocument(int voteType, Document document, User user) {
        this.voteType = voteType;
        this.document = document;
        this.user = user;
    }

    public Long getVoteId() {
        return voteId;
    }

    public void setVoteId(Long voteId) {
        this.voteId = voteId;
    }

    public int getVoteType() {
        return voteType;
    }

    public void setVoteType(int voteType) {
        this.voteType = voteType;
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

    @Override
    public String toString() {
        return "VoteDocument{" +
                "voteId=" + voteId +
                ", voteType=" + voteType +
                ", document=" + document +
                ", user=" + user +
                '}';
    }
}



