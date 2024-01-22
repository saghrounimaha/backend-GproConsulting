package com.pfe.Repository;


import com.pfe.model.Responsable_societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Isociete extends JpaRepository<Responsable_societe,Long> {
}
