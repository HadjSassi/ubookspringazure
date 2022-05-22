package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User implements Serializable {
    @Id
    @Column(nullable = false, updatable = false, length = 100)
    private String uid ;
    private String mailUser;
    private String nomUser;
    private String prenomUser;
    private String urlPicUser;
    private String job;
    private String urlFacebook;
    private String urlLinkedIn;
    private int score;
    private String description;
    private String universities ;
    private boolean enabled;
    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getMailUser() {
        return mailUser;
    }

    public void setMailUser(String mailUser) {
        this.mailUser = mailUser;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getUrlPicUser() {
        return urlPicUser;
    }

    public void setUrlPicUser(String urlPicUser) {
        this.urlPicUser = urlPicUser;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getUrlFacebook() {
        return urlFacebook;
    }

    public void setUrlFacebook(String urlFacebook) {
        this.urlFacebook = urlFacebook;
    }

    public String getUrlLinkedIn() {
        return urlLinkedIn;
    }

    public void setUrlLinkedIn(String urlLinkedIn) {
        this.urlLinkedIn = urlLinkedIn;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", mailUser='" + mailUser + '\'' +
                ", nomUser='" + nomUser + '\'' +
                ", prenomUser='" + prenomUser + '\'' +
                ", urlPicUser='" + urlPicUser + '\'' +
                ", job='" + job + '\'' +
                ", urlFacebook='" + urlFacebook + '\'' +
                ", urlLinkedIn='" + urlLinkedIn + '\'' +
                ", score=" + score +
                ", description='" + description + '\'' +
                ", isEnabled=" + enabled +
                '}';
    }
}
