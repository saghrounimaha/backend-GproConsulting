package com.pfe.Repository;

import com.pfe.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Iformation  extends JpaRepository<Formation,Long>{
}
