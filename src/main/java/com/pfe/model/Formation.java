package com.pfe.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Formation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String titre_Formation;
    private Date date_Debut;
    private  Date date_Fin;
    private  String discrepition;
    private  String duree_Formation;
    private  String prix_Formation;
    private  String photo;
@ManyToOne
private Responsable_CentreFormation responsableCentreFormation;
@ManyToOne
private Candidat candidat;

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Responsable_CentreFormation getResponsableCentreFormation() {
        return this.responsableCentreFormation;
    }

    public void setResponsableCentreFormation(Responsable_CentreFormation responsableCentreFormation) {
        this.responsableCentreFormation = responsableCentreFormation;
    }

    public Formation() {
    }

    public Formation(String titre_Formation, Date date_Debut, Date date_Fin, String discrepition, String duree_Formation, String prix_Formation, String photo) {
        this.titre_Formation = titre_Formation;
        this.date_Debut = date_Debut;
        this.date_Fin = date_Fin;
        this.discrepition = discrepition;
        this.duree_Formation = duree_Formation;
        this.prix_Formation = prix_Formation;
        this.photo = photo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitre_Formation() {
        return titre_Formation;
    }

    public void setTitre_Formation(String titre_Formation) {
        this.titre_Formation = titre_Formation;
    }

    public Date getDate_Debut() {
        return date_Debut;
    }

    public void setDate_Debut(Date date_Debut) {
        this.date_Debut = date_Debut;
    }

    public Date getDate_Fin() {
        return date_Fin;
    }

    public void setDate_Fin(Date date_Fin) {
        this.date_Fin = date_Fin;
    }

    public String getDiscrepition() {
        return discrepition;
    }

    public void setDiscrepition(String discrepition) {
        this.discrepition = discrepition;
    }

    public String getDuree_Formation() {
        return duree_Formation;
    }

    public void setDuree_Formation(String duree_Formation) {
        this.duree_Formation = duree_Formation;
    }

    public String getPrix_Formation() {
        return prix_Formation;
    }

    public void setPrix_Formation(String prix_Formation) {
        this.prix_Formation = prix_Formation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
