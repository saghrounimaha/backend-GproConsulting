package com.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Responsable_societe extends Utilisateur {

    private String site_web;
    private String description;

    private Integer telephone;
    @JsonIgnore
@OneToMany(mappedBy = "responsableSociete")
private List<Offre_Stage> stageList;

    public List<Offre_Stage> getStageList() {
        return stageList;
    }

    public void setStageList(List<Offre_Stage> stageList) {
        this.stageList = stageList;
    }

    public Responsable_societe() {

    }

    public String getSite_web() {
        return site_web;
    }

    public void setSite_web(String site_web) {
        this.site_web = site_web;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {

        this.telephone = telephone;
    }

    public Responsable_societe(String nom, String prenom, String email, boolean etat, String adresse, String photo, String username, String password, String confirmerpassword, List<Role> roleList, String site_web, String description, Integer telephone, List<Offre_Stage> stageList) {
        super(nom, prenom, email, etat, adresse, photo, username, password, confirmerpassword, roleList);
        this.site_web = site_web;
        this.description = description;

        this.telephone = telephone;
        this.stageList = stageList;
    }
}

