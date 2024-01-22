package com.pfe.Repository;

import com.pfe.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Icommentaire extends JpaRepository<Commentaire,Long> {
}
