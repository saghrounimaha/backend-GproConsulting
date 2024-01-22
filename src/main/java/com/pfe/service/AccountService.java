package com.pfe.service;


import com.pfe.model.*;

import java.util.Calendar;

public interface AccountService {
    Candidat saveCandidat(Candidat candidat);
    Admin saveAdmin(Admin admin);
    Responsable_CentreFormation saveCenter(Responsable_CentreFormation centreFormation);
    Responsable_societe savesociete(Responsable_societe societe);
    Role save(Role role);
    Utilisateur loadUserByUsername(String username);
     void addRoleToUser(String username, String rolename);

}
