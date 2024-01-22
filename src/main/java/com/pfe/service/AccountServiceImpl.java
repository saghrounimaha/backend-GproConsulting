package com.pfe.service;


import com.pfe.Repository.*;

import com.pfe.model.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private Iutilisateur appUserRepository;
    private Iadmin iAdmin;
    private IcentreForma iCentreForma;
    private Isociete iSociete;
    private Icandidat iStagiaire;
    private Irole appRoleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    public AccountServiceImpl(Iutilisateur appUserRepository, Iadmin iAdmin, IcentreForma iCentreForma, Isociete iSociete, Icandidat iStagiaire, Irole appRoleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.appUserRepository = appUserRepository;
        this.iAdmin = iAdmin;
        this.iCentreForma = iCentreForma;
        this.iSociete = iSociete;
        this.iStagiaire = iStagiaire;
        this.appRoleRepository = appRoleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public Admin saveAdmin(Admin admin) {
        Utilisateur user=appUserRepository.findByUsername(admin.getUsername());
            if(user!=null) throw new RuntimeException("User already exists");
        Admin appUser=new Admin();
             appUser.setPassword(bCryptPasswordEncoder.encode(admin.getPassword()));
            System.out.println(bCryptPasswordEncoder.encode(admin.getPassword()));
            appUser.setConfirmerpassword(bCryptPasswordEncoder.encode(admin.getConfirmerpassword()));
            System.out.println(bCryptPasswordEncoder.encode(admin.getConfirmerpassword()));
            appUser.setNom(admin.getNom());
            appUser.setPrenom(admin.getPrenom());
            appUser.setAdresse(admin.getAdresse());
        appUser.setEmail(admin.getEmail());
        appUser.setPhoto(admin.getPhoto());
        appUser.setPrenom(admin.getPrenom());
        appUser.setUsername(admin.getUsername());
        appUserRepository.save(appUser);
            addRoleToUser(admin.getUsername(),"Admin");
            return appUser;
        }



    @Override
        public Responsable_CentreFormation saveCenter(Responsable_CentreFormation centreForma) {
          Utilisateur  user=appUserRepository.findByUsername(centreForma.getUsername());
          if(user!=null) throw new RuntimeException("User already exists");
          if(!centreForma.getPassword().equals(centreForma.getConfirmerpassword())) throw new RuntimeException("Please confirm your password");
          Responsable_CentreFormation appUser=new Responsable_CentreFormation();
          appUser.setUsername(centreForma.getUsername());
         appUser.setPassword(bCryptPasswordEncoder.encode(centreForma.getPassword()));
         System.out.println(bCryptPasswordEncoder.encode(centreForma.getPassword()));
         appUser.setConfirmerpassword(bCryptPasswordEncoder.encode(centreForma.getConfirmerpassword()));
         System.out.println(bCryptPasswordEncoder.encode(centreForma.getConfirmerpassword()));
         appUser.setNom(centreForma.getNom());
          appUser.setDescription(centreForma.getDescription());
          appUser.setPhoto(centreForma.getPhoto());
          appUser.setNom(centreForma.getNom());
          appUser.setAdresse(centreForma.getAdresse());
          appUser.setEmail(centreForma.getEmail());
          appUser.setTelephone(centreForma.getTelephone());
          appUser.setSiteWeb(centreForma.getSiteWeb());
         appUserRepository.save(appUser);
          addRoleToUser(centreForma.getUsername(),"ResponsableCentre");
         return appUser;
    }

    @Override
      public Responsable_societe savesociete(Responsable_societe societe) {
         Utilisateur  user=appUserRepository.findByUsername(societe.getUsername());
          if(user!=null) throw new RuntimeException("User already exists");
          if(!societe.getPassword().equals(societe.getConfirmerpassword())) throw new RuntimeException("Please confirm your password");
          Responsable_societe appUser=new Responsable_societe();
          appUser.setUsername(societe.getUsername());
          appUser.setPassword(bCryptPasswordEncoder.encode(societe.getPassword()));
          System.out.println(bCryptPasswordEncoder.encode(societe.getPassword()));
          appUser.setConfirmerpassword(bCryptPasswordEncoder.encode(societe.getConfirmerpassword()));
          System.out.println(bCryptPasswordEncoder.encode(societe.getConfirmerpassword()));
        appUser.setNom(societe.getNom());
          appUser.setAdresse(societe.getAdresse());
          appUser.setEmail(societe.getEmail());
          appUser.setTelephone(societe.getTelephone());
          appUser.setDescription(societe.getDescription());
          appUser.setPrenom(societe.getPrenom());
          appUser.setSite_web(societe.getSite_web());
          appUser.setPhoto(societe.getPhoto());

          this.appUserRepository.save(appUser);
          addRoleToUser(societe.getUsername(),"ResponsableSociete");
         return appUser;
    }


    @Override
        public Candidat saveCandidat(Candidat candidat) {
        Utilisateur  user=appUserRepository.findByUsername(candidat.getUsername());
        if(user!=null) throw new RuntimeException("User already exists");
        if(!candidat.getPassword().equals(candidat.getConfirmerpassword())) throw new RuntimeException("Please confirm your password");
        Candidat appUser=new Candidat();
        appUser.setUsername(candidat.getUsername());
        appUser.setPassword(bCryptPasswordEncoder.encode(candidat.getPassword()));
        System.out.println(bCryptPasswordEncoder.encode(candidat.getPassword()));
        appUser.setConfirmerpassword(bCryptPasswordEncoder.encode(candidat.getConfirmerpassword()));
        System.out.println(bCryptPasswordEncoder.encode(candidat.getConfirmerpassword()));
        appUser.setNom(candidat.getNom());
        appUser.setAdresse(candidat.getAdresse());
        appUser.setEmail(candidat.getEmail());
        appUser.setTelephone(candidat.getTelephone());
        appUser.setDate_Naissance(candidat.getDate_Naissance());
        appUser.setPhoto(candidat.getPhoto());
        appUser.setNiveau_etude(candidat.getNiveau_etude());
        appUser.setCompte_linkdln(candidat.getCompte_linkdln());
        appUser.setPrenom(candidat.getPrenom());
        appUserRepository.save(appUser);
        addRoleToUser(candidat.getUsername(),"candidat");
        return appUser;
    }
    @Override
    public Role save(Role role) {
        return appRoleRepository.save(role);
    }

    @Override
    public Utilisateur loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        Utilisateur appUser=appUserRepository.findByUsername(username);
        Role appRole=appRoleRepository.findByRoleName(rolename);
        appUser.getRoleList().add(appRole);
    }
}
