package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Institus extends UniversityOrganisms implements Serializable {

    private String universite ;

    private String abreviation;

    private String region ;

    private String filieres ;

    private String sexe ;

    private String type ;

    private String nbChambre ;

    private String reglement;

    public Institus() {
    }

    public Institus(String nom, String historique, String logo, String urlOfficiel, String urlPartenaires, String urlClubs, String urlInstitus, String picsUrls, String superior, String universite, String abreviation, String region, String filieres, String sexe, String type, String nbChambre, String reglement) {
        super(nom, historique, logo, urlOfficiel, urlPartenaires, urlClubs, urlInstitus, picsUrls, superior);
        this.universite = universite;
        this.abreviation = abreviation;
        this.region = region;
        this.filieres = filieres;
        this.sexe = sexe;
        this.type = type;
        this.nbChambre = nbChambre;
        this.reglement = reglement;
    }

    public String getUniversite() {
        return universite;
    }

    public void setUniversite(String universite) {
        this.universite = universite;
    }

    public String getAbreviation() {
        return abreviation;
    }

    public void setAbreviation(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getFilieres() {
        return filieres;
    }

    public void setFilieres(String filieres) {
        this.filieres = filieres;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNbChambre() {
        return nbChambre;
    }

    public void setNbChambre(String nbChambre) {
        this.nbChambre = nbChambre;
    }

    public String getReglement() {
        return reglement;
    }

    public void setReglement(String reglement) {
        this.reglement = reglement;
    }

    @Override
    public String toString() {
        return "Institus{" +
                "universite='" + universite + '\'' +
                ", abreviation='" + abreviation + '\'' +
                ", region='" + region + '\'' +
                ", filieres='" + filieres + '\'' +
                ", sexe='" + sexe + '\'' +
                ", type='" + type + '\'' +
                ", nbChambre='" + nbChambre + '\'' +
                ", reglement='" + reglement + '\'' +
                '}';
    }
}

