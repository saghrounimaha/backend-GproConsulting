package com.pfe.Repository;


import com.pfe.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iutilisateur extends JpaRepository<Utilisateur,Long> {
    public Utilisateur findByUsername(String username);

}
