package com.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Client on 20/04/2020.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DemandeStage  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    private Candidat stagiaire;
    @ManyToOne
    private Offre_Stage stage;
    private String photo;
    private String lettremotivation;

    public String getLettremotivation() {
        return lettremotivation;
    }

    public void setLettremotivation(String lettremotivation) {
        this.lettremotivation = lettremotivation;
    }

    public DemandeStage() {
    }

    public DemandeStage(Candidat stagiaire, Offre_Stage stage, String photo, String lettremotivation) {
        this.stagiaire = stagiaire;
        this.stage = stage;
        this.photo = photo;
        this.lettremotivation = lettremotivation;
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

    public Offre_Stage getStage() {
        return this.stage;
    }

    public void setStage(Offre_Stage stage) {
        this.stage = stage;
    }

    public String getPhoto() {
        return this.photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
