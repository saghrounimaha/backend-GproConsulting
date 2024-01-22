package com.pfe.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Admin extends  Utilisateur {







    public Admin() {
    }

    public Admin(String nom, String prenom, String email, boolean etat, String adresse, String photo, String username, String password, String confirmerpassword, List<Role> roleList) {
        super(nom, prenom, email, etat, adresse, photo, username, password, confirmerpassword, roleList);
    }
}
