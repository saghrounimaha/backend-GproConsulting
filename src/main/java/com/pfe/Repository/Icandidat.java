package com.pfe.Repository;

import com.pfe.model.Candidat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icandidat extends JpaRepository<Candidat,Long> {
}
