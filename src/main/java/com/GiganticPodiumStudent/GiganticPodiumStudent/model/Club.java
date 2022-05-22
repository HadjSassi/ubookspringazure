package com.GiganticPodiumStudent.GiganticPodiumStudent.model;


import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Club extends UniversityOrganisms implements Serializable {


    private String domaine ;

    public Club() {
    }

    public Club(String nom, String historique, String logo, String urlOfficiel, String urlPartenaires, String urlClubs, String urlInstitus, String picsUrls, String superior, String domaine) {
        super(nom, historique, logo, urlOfficiel, urlPartenaires, urlClubs, urlInstitus, picsUrls, superior);
        this.domaine = domaine;
    }


    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    @Override
    public String toString() {
        return "Club{" +
                "domaine='" + domaine + '\'' +
                '}';
    }
}

