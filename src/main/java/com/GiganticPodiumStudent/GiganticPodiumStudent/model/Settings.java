package com.GiganticPodiumStudent.GiganticPodiumStudent.model;

import javax.persistence.*;

@Entity
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSetting;

    private String matiere;

    private String niveau ;

    private String annee;

    public Long getIdSetting() {
        return idSetting;
    }

    public void setIdSetting(Long idSetting) {
        this.idSetting = idSetting;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    @Override
    public String toString() {
        return "settings{" +
                "idSetting=" + idSetting +
                ", matiere='" + matiere + '\'' +
                ", niveau='" + niveau + '\'' +
                ", annee='" + annee + '\'' +
                '}';
    }
}
