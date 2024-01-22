package com.pfe.Repository;


import com.pfe.model.Responsable_CentreFormation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IcentreForma extends JpaRepository<Responsable_CentreFormation,Long> {
}
