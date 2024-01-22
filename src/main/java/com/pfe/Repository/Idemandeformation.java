package com.pfe.Repository;

import com.pfe.model.Demandeformatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Idemandeformation extends JpaRepository<Demandeformatin,Long> {
}
