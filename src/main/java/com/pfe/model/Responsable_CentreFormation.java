package com.pfe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Responsable_CentreFormation extends Utilisateur {
    private String siteWeb;
    private String description;

    private Integer telephone;
    @JsonIgnore
@OneToMany (mappedBy = "responsableCentreFormation")
private List<Formation>formationList;


    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
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

    public Responsable_CentreFormation() {
    }

    public Responsable_CentreFormation(String nom, String prenom, String email, boolean etat, String adresse, String photo, String username, String password, String confirmerpassword, List<Role> roleList, String siteWeb, String description, String logo, Integer telephone, List<Formation> formationList) {
        super(nom, prenom, email, etat, adresse, photo, username, password, confirmerpassword, roleList);
        this.siteWeb = siteWeb;
        this.description = description;

        this.telephone = telephone;
        this.formationList = formationList;
    }
}
