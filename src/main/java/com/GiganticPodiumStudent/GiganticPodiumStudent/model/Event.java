package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Event implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    private String clubs ;
    private String institus ;
    private String trainingCenters;
    private String affiche;
    private String themes ;
    private String capacity ;
    private String address ;
    private String email ;
    private String tel ;
    private String registrationLink ;
    private String description;
    private String price ;
    private String partenaires ;
    private String startingDate;
    @Column(columnDefinition = "text")
    private String participants;
    private String finishingDate ;
    private String registrationDateLimit;
    private String shown ;
    private String picsUrl ;
    @Enumerated(value = EnumType.STRING)
    private EventType type ;
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(columnDefinition = "varchar(100)",nullable = false, name = "uid")
    private User uid ;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getClubs() {
        return clubs;
    }

    public void setClubs(String clubs) {
        this.clubs = clubs;
    }

    public String getInstitus() {
        return institus;
    }

    public void setInstitus(String institus) {
        this.institus = institus;
    }

    public String getTrainingCenters() {
        return trainingCenters;
    }

    public void setTrainingCenters(String trainingCenters) {
        this.trainingCenters = trainingCenters;
    }

    public String getAffiche() {
        return affiche;
    }

    public void setAffiche(String affiche) {
        this.affiche = affiche;
    }

    public String getThemes() {
        return themes;
    }

    public void setThemes(String themes) {
        this.themes = themes;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getRegistrationLink() {
        return registrationLink;
    }

    public void setRegistrationLink(String registrationLink) {
        this.registrationLink = registrationLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPartenaires() {
        return partenaires;
    }

    public void setPartenaires(String partenaires) {
        this.partenaires = partenaires;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getFinishingDate() {
        return finishingDate;
    }

    public void setFinishingDate(String finishingDate) {
        this.finishingDate = finishingDate;
    }

    public String getRegistrationDateLimit() {
        return registrationDateLimit;
    }

    public void setRegistrationDateLimit(String registrationDateLimit) {
        this.registrationDateLimit = registrationDateLimit;
    }

    public String getShown() {
        return shown;
    }

    public void setShown(String shown) {
        this.shown = shown;
    }

    public String getPicsUrl() {
        return picsUrl;
    }

    public void setPicsUrl(String picsUrl) {
        this.picsUrl = picsUrl;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public User getUid() {
        return uid;
    }

    public void setUid(User uid) {
        this.uid = uid;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", clubs='" + clubs + '\'' +
                ", institus='" + institus + '\'' +
                ", trainingCenters='" + trainingCenters + '\'' +
                ", affiche='" + affiche + '\'' +
                ", themes='" + themes + '\'' +
                ", capacity='" + capacity + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", registrationLink='" + registrationLink + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", partenaires='" + partenaires + '\'' +
                ", participants='" + participants + '\'' +
                ", startingDate='" + startingDate + '\'' +
                ", finishingDate='" + finishingDate + '\'' +
                ", registrationDateLimit='" + registrationDateLimit + '\'' +
                ", shown='" + shown + '\'' +
                ", picsUrl='" + picsUrl + '\'' +
                ", type=" + type +
                ", uid=" + uid +
                '}';
    }
}
