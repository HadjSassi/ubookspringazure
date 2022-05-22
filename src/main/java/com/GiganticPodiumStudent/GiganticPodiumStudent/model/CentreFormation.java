package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class CentreFormation extends UniversityOrganisms implements Serializable{

    private String abreviation ;

    private String region ;

    private String domaines ;

    private String reglement ;


    public CentreFormation() {
    }

    public CentreFormation(String nom, String historique, String logo, String urlOfficiel, String urlPartenaires, String urlClubs, String urlInstitus, String picsUrls, String superior, String abreviation, String region, String domaines, String reglement) {
        super(nom, historique, logo, urlOfficiel, urlPartenaires, urlClubs, urlInstitus, picsUrls, superior);
        this.abreviation = abreviation;
        this.region = region;
        this.domaines = domaines;
        this.reglement = reglement;
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

    public String getDomaines() {
        return domaines;
    }

    public void setDomaines(String domaines) {
        this.domaines = domaines;
    }

    public String getReglement() {
        return reglement;
    }

    public void setReglement(String reglement) {
        this.reglement = reglement;
    }

    @Override
    public String toString() {
        return "CentreFormation{" +
                "abreviation='" + abreviation + '\'' +
                ", region='" + region + '\'' +
                ", domaines='" + domaines + '\'' +
                ", reglement='" + reglement + '\'' +
                '}';
    }
}

