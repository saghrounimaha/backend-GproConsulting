package com.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Offre_Stage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id ;
    private String titre_offre;
    private String technologie;
    private String type;
    private Date date_debut;
    private Date date_fin;
    private String nombre_stagiaire;
    private String duree_stage;
    private String description;

@ManyToOne
private Responsable_societe responsableSociete;
@ManyToOne

private  Secteur secteur;
@JsonIgnore
@OneToMany (mappedBy = "offreStage")
private  List<Commentaire>commentaireList;
@JsonIgnore
@ManyToOne
private  Candidat candidat;

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Responsable_societe getResponsableSociete() {
        return responsableSociete;
    }

    public void setResponsableSociete(Responsable_societe responsableSociete) {
        this.responsableSociete = responsableSociete;
    }

    public Offre_Stage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Offre_Stage(String titre_offre, String technologie, String type, Date date_debut, Date date_fin, String nombre_stagiaire, String duree_stage, String description) {
        this.titre_offre = titre_offre;
        this.technologie = technologie;
        this.type = type;
        this.date_debut = date_debut;
        this.date_fin = date_fin;


        this.nombre_stagiaire = nombre_stagiaire;
        this.duree_stage = duree_stage;
        this.description = description;
    }

    public String getTitre_offre() {
        return titre_offre;
    }

    public void setTitre_offre(String titre_offre) {
        this.titre_offre = titre_offre;
    }

    public String getTechnologie() {
        return technologie;
    }

    public void setTechnologie(String technologie) {
        this.technologie = technologie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    public String getNombre_stagiaire() {
        return nombre_stagiaire;
    }

    public void setNombre_stagiaire(String nombre_stagiaire) {
        this.nombre_stagiaire = nombre_stagiaire;
    }

    public String getDuree_stage() {
        return duree_stage;
    }

    public void setDuree_stage(String duree_stage) {
        this.duree_stage = duree_stage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
