package com.pfe.Repository;


import com.pfe.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Iadmin extends JpaRepository<Admin,Long> {



}
