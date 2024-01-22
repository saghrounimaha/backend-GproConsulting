package com.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Secteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    @JsonIgnore
@OneToMany(mappedBy = "secteur")
private List<Offre_Stage >offreStageList;


    public List<Offre_Stage> getOffreStageList() {
        return offreStageList;
    }

    public void setOffreStageList(List<Offre_Stage> offreStageList) {
        this.offreStageList = offreStageList;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Secteur() {
    }

    public Secteur(String nom) {
        this.nom = nom;
    }
}
