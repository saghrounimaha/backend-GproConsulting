package com.pfe.Repository;

import com.pfe.model.Offre_Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IoffreStage extends JpaRepository<Offre_Stage,Long> {
}
