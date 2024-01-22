package com.pfe.Repository;

import com.pfe.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface Irole extends JpaRepository<Role,Long>{
    Role findByRoleName(String roleName);
}
