package com.pfe.model;


import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;


@Entity

public class Candidat extends Utilisateur {

    private Date date_Naissance;
    private String niveau_etude;
    private String compte_linkdln;
    private String photo;
    private Integer telephone;
@OneToMany (mappedBy = "candidat")
    private List<Offre_Stage>offreStageList;

@OneToMany (mappedBy = "candidat")
    private List<Formation>formationList;
@OneToMany(mappedBy = "candidat")
   private  List<Commentaire>commentaireList;

    public List<Commentaire> getCommentaireList() {
        return commentaireList;
    }

    public void setCommentaireList(List<Commentaire> commentaireList) {
        this.commentaireList = commentaireList;
    }


    public List<Formation> getFormationList() {
        return formationList;
    }

    public void setFormationList(List<Formation> formationList) {
        this.formationList = formationList;
    }




    public List<Offre_Stage> getOffreStageList() {
        return offreStageList;
    }

    public void setOffreStageList(List<Offre_Stage> offreStageList) {
        this.offreStageList = offreStageList;
    }

    public Candidat() {
    }

    public Date getDate_Naissance() {
        return date_Naissance;
    }

    public void setDate_Naissance(Date date_Naissance) {
        this.date_Naissance = date_Naissance;
    }

    public String getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }

    public String getCompte_linkdln() {
        return compte_linkdln;
    }

    public void setCompte_linkdln(String compte_linkdln) {
        this.compte_linkdln = compte_linkdln;
    }


    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getTelephone() {
        return telephone;
    }

    public void setTelephone(Integer telephone) {
        this.telephone = telephone;
    }

    public Candidat(String nom, String prenom, String email, boolean etat, String adresse, String photo, String username, String password, String confirmerpassword, List<Role> roleList, Date date_Naissance, String niveau_etude, String compte_linkdln, String photo1, Integer telephone, List<Offre_Stage> offreStageList, List<Formation> formationList, List<Commentaire> commentaireList) {
        super(nom, prenom, email, etat, adresse, photo, username, password, confirmerpassword, roleList);
        this.date_Naissance = date_Naissance;
        this.niveau_etude = niveau_etude;
        this.compte_linkdln = compte_linkdln;
        this.photo = photo;
        this.telephone = telephone;
        this.offreStageList = offreStageList;
        this.formationList = formationList;
        this.commentaireList = commentaireList;
    }
}
