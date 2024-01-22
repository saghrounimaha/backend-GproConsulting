package com.pfe.Repository;

import com.pfe.model.DemandeStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Idemandestage extends JpaRepository<DemandeStage,Long> {
}
