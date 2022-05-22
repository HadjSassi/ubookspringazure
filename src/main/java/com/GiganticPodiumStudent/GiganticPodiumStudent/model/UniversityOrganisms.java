package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class UniversityOrganisms implements Serializable {
    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private Long id ;
    private String nom;
    private String historique;
    private String logo ;
    private String urlOfficiel ;
    private String urlPartenaires ;
    private String urlClubs ;
    private String urlCfs ;
    private String urlInstitus;
    private String picsUrls ;
    private String superior ;
    public UniversityOrganisms() {
    }

    public UniversityOrganisms(String nom, String historique, String logo, String urlOfficiel, String urlPartenaires, String urlClubs, String urlInstitus, String picsUrls, String superior) {
        this.nom = nom;
        this.historique = historique;
        this.logo = logo;
        this.urlOfficiel = urlOfficiel;
        this.urlPartenaires = urlPartenaires;
        this.urlClubs = urlClubs;
        this.urlInstitus = urlInstitus;
        this.picsUrls = picsUrls;
        this.superior = superior;
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

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getUrlOfficiel() {
        return urlOfficiel;
    }

    public void setUrlOfficiel(String urlOfficiel) {
        this.urlOfficiel = urlOfficiel;
    }

    public String getUrlPartenaires() {
        return urlPartenaires;
    }

    public void setUrlPartenaires(String urlPartenaires) {
        this.urlPartenaires = urlPartenaires;
    }

    public String getUrlClubs() {
        return urlClubs;
    }

    public void setUrlClubs(String urlClubs) {
        this.urlClubs = urlClubs;
    }

    public String getUrlInstitus() {
        return urlInstitus;
    }

    public void setUrlInstitus(String urlInstitus) {
        this.urlInstitus = urlInstitus;
    }

    public String getPicsUrls() {
        return picsUrls;
    }

    public void setPicsUrls(String picsUrls) {
        this.picsUrls = picsUrls;
    }

    public String  getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    @Override
    public String toString() {
        return "UniversityOrganisms{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", historique='" + historique + '\'' +
                ", logo='" + logo + '\'' +
                ", urlOfficiel='" + urlOfficiel + '\'' +
                ", urlPartenaires='" + urlPartenaires + '\'' +
                ", urlClubs='" + urlClubs + '\'' +
                ", urlInstitus='" + urlInstitus + '\'' +
                ", picsUrls='" + picsUrls + '\'' +
                ", superior=" + superior +
                '}';
    }
}


