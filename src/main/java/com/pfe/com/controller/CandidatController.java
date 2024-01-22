package com.pfe.com.controller;

import com.pfe.Repository.Icandidat;
import com.pfe.file.StorageService;
import com.pfe.model.Candidat;
import com.pfe.model.Role;
import com.pfe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Candidat")
public class CandidatController {
    @Autowired
    private Icandidat icandidat;

    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;

    //add responsable societe
    @PostMapping(value = "/addCandidat")
    public Candidat createCandidat(@RequestBody Candidat candidat) {
        return accountService.saveCandidat(candidat);
    }
//    @PostMapping(value = "/addCandidat")
//    public Candidat createCandidat(String nom, String prenom, String email, boolean etat, String adresse, String username, String password, MultipartFile photo) {
//        Candidat candidat = new Candidat();
//        candidat.setNom(nom);
//        candidat.setPrenom(prenom);
//        candidat.setEmail(email);
//        candidat.setEtat(etat);
//        candidat.setAdresse(adresse);
//        candidat.setUsername(username);
//        candidat.setPassword(password);
//        storageService.store(photo);
//        candidat.setPhoto(photo.getOriginalFilename());
//        return icandidat.save(candidat);
//
//    }

    // update responsable societe
    @PutMapping("/updateCandidat/{Id}")
    public Candidat modif(@RequestBody Candidat candidat, @PathVariable Long Id) {
        Candidat candidat0 = icandidat.getOne(Id);

        if (candidat.getAdresse() == null) {
            candidat.setAdresse(candidat0.getAdresse());
        }

        if (candidat.getEmail() == null) {
            candidat.setEmail(candidat0.getEmail());
        }
        if (candidat.getNom() == null) {
            candidat.setNom(candidat0.getNom());
        }

        if (candidat.getPrenom() == null) {
            candidat.setPrenom(candidat0.getPrenom());
        }

        if (candidat.getCompte_linkdln() == null) {
            candidat.setCompte_linkdln(candidat0.getCompte_linkdln());
        }
        if (candidat.getDate_Naissance() == null) {
            candidat.setDate_Naissance(candidat0.getDate_Naissance());
        }
        if (candidat.getNiveau_etude() == null) {
            candidat.setNiveau_etude(candidat0.getNiveau_etude());
        }
        if (candidat.getTelephone() == null) {
            candidat.setTelephone(candidat0.getTelephone());
        }
        candidat.setId(Id);
        candidat.setUsername(candidat0.getUsername());
        candidat.setPassword(candidat0.getPassword());
        candidat.setConfirmerpassword(candidat0.getConfirmerpassword());
        candidat.setRoleList(candidat0.getRoleList());
        return icandidat.saveAndFlush(candidat);
    }


    // delete resp_societe
    @DeleteMapping("/deleteCandidat/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            icandidat.deleteById(Id);
            hashMap.put("etat", "Candidat supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "Candidat non supprimer");
            return hashMap;
        }
    }


    // Get All Responsable_societe
    @GetMapping(value = "/GetAllCandidat")
    public List<Candidat> allCandidat() {
        return icandidat.findAll();


    }

    //Get by ID
    @GetMapping("/getbyId/{id}")
    public Candidat getById(Long id) {
        return icandidat.getOne(id);
    }

    @GetMapping("/allvalide") //liste de formation
    public List<Candidat> getAllCentrevalide() {
        List<Candidat> centreFormaList = new ArrayList<>();
        for (Candidat centreFormation : icandidat.findAll())
            if (centreFormation.isEtat())
                centreFormaList.add(centreFormation);


        return centreFormaList;
    }

    @GetMapping("/allnonvalide")  //liste valide centreformation
    public List<Candidat> getAllcandidatonvalide() {
        List<Candidat> candidats = new ArrayList<>();
        for (Candidat candidat : icandidat.findAll())
            if (!candidat.isEtat())
                candidats.add(candidat);


        return candidats;
    }

    @GetMapping("/vaidercentre/{id}")  // la liste des centre formation non valide
    public Candidat validercandidat(@PathVariable Long id) {
        Candidat candidat = icandidat.getOne(id);
        if (!candidat.isEtat())
            candidat.setEtat(true);
        return icandidat.saveAndFlush(candidat);
    }
}
