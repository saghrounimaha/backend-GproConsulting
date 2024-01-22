package com.pfe.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Demandeformatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Candidat stagiaire;
    @ManyToOne
    private Formation formation;
    private String cv;

    private Date date =new Date();

    public Demandeformatin() {
    }

    public Demandeformatin(Candidat stagiaire, Formation formation, String cv, Date date) {
        this.stagiaire = stagiaire;
        this.formation = formation;
        this.cv = cv;
        this.date = date;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Candidat getStagiaire() {
        return this.stagiaire;
    }

    public void setStagiaire(Candidat stagiaire) {
        this.stagiaire = stagiaire;
    }

    public Formation getFormation() {
        return this.formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public String getCv() {
        return this.cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
