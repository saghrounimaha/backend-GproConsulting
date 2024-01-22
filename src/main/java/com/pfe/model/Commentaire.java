package com.pfe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Commentaire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Date date =new Date();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @ManyToOne
private Offre_Stage offreStage;
@ManyToOne
private Candidat candidat;

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Offre_Stage getOffreStage() {
        return offreStage;
    }

    public void setOffreStage(Offre_Stage offreStage) {
        this.offreStage = offreStage;
    }

    public Commentaire(String description, Date date, Offre_Stage offreStage, Candidat candidat) {
        this.description = description;
        this.date = date;
        this.offreStage = offreStage;
        this.candidat = candidat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Commentaire() {
    }
}
