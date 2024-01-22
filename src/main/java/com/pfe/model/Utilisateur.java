package com.pfe.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance( strategy  = InheritanceType . TABLE_PER_CLASS)
        public abstract class Utilisateur implements Serializable{
    @Id
    @GeneratedValue

    private Long id;
    private String nom;
    private  String prenom;
    private  String email;
    private boolean etat;
    private  String adresse;
    private  String photo;
    @Column(unique = true)
    private  String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;
    private  String confirmerpassword;
@ManyToMany (fetch = FetchType.EAGER)
private List<Role> roleList =new ArrayList<>();

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmerpassword() {
        return confirmerpassword;
    }

    public void setConfirmerpassword(String confirmerpassword) {
        this.confirmerpassword = confirmerpassword;
    }

    public Utilisateur(String nom, String prenom, String email, boolean etat, String adresse, String photo, String username, String password, String confirmerpassword, List<Role> roleList) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.etat = etat;
        this.adresse = adresse;
        this.photo = photo;
        this.username = username;
        this.password = password;
        this.confirmerpassword = confirmerpassword;
        this.roleList = roleList;
    }

    public  Utilisateur() {
    }
}
