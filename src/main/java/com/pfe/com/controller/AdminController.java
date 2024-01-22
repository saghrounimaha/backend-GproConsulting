package com.pfe.com.controller;


import com.pfe.Repository.Iadmin;
import com.pfe.Repository.Iutilisateur;
import com.pfe.model.Admin;
import com.pfe.model.Utilisateur;
import com.pfe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Admin")
public class AdminController {

    @Autowired
    private Iadmin adminRepo;
    @Autowired
    private AccountService accountService;
    @Autowired
    private Iutilisateur iutilisateur;

    //add admin
    @PostMapping(value = "/addAdmin")
    public Admin createAdmin(@RequestBody Admin admin) {
        return accountService.saveAdmin(admin);

    }

    // update Admis
    @PutMapping("/updateAdmin/{Id}")
    public Admin modif(@RequestBody Admin admin, @PathVariable Long Id) {
        Admin admin0 = adminRepo.getOne(Id);
        if (admin.getAdresse() == null) {
            admin.setAdresse(admin0.getAdresse());
        }
        if (admin.getConfirmerpassword() == null) {
            admin.setConfirmerpassword(admin0.getConfirmerpassword());
        }
        if (admin.getEmail() == null) {
            admin.setEmail(admin0.getEmail());
        }
        if (admin.getNom() == null) {
            admin.setNom(admin0.getNom());
        }
        if (admin.getPassword() == null) {
            admin.setPassword(admin0.getPassword());
        }
        if (admin.getPrenom() == null) {
            admin.setPrenom(admin0.getPrenom());
        }
        if (admin.getUsername() == null) {
            admin.setUsername(admin0.getUsername());
        }

        admin.setId(Id);
        return adminRepo.saveAndFlush(admin);
    }


    // delete Admis
    @DeleteMapping("/deleteAdmin/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            adminRepo.deleteById(Id);
            hashMap.put("etat", "admin supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "Admin non supprimer");
            return hashMap;
        }
    }


    // Get All ADMIN
    @GetMapping(value = "/GetAll")
    public List<Admin> allAdmin() {
        return adminRepo.findAll();


    }

    //Get by ID
    @GetMapping("/getbyId/{id}")
    public Admin getById(Long id) {
        return adminRepo.getOne(id);
    }

    @GetMapping("/getprofile")

    public Utilisateur getprofile(Principal prinsipal) {
        return iutilisateur.findByUsername(prinsipal.getName());
    }
}
