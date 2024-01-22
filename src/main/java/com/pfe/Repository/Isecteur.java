package com.pfe.Repository;


import com.pfe.model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Isecteur extends JpaRepository<Secteur,Long> {
}
