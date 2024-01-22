package com.pfe.com.controller;

import com.pfe.Repository.Isecteur;
import com.pfe.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/secteur")
@CrossOrigin("*")
public class SecteurController {
    @Autowired
    private Isecteur isecteur;


    //add responsable societe
    @PostMapping(value = "/addsecteur")
    public Secteur createSecteur(@RequestBody Secteur secteur) {
        return isecteur.save(secteur);

    }

    // update responsable societe
    @PutMapping("/updateoffrestage/{Id}")
    public Secteur modif(@RequestBody Secteur secteur, @PathVariable Long Id) {
        Secteur secteur1 = isecteur.getOne(Id);
        if (secteur.getNom() == null) {
            secteur.setNom(secteur1.getNom());
        }
        secteur.setId(Id);
        return isecteur.saveAndFlush(secteur);
    }


    // delete resp_societe
    @DeleteMapping("/deletesecteur/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            isecteur.deleteById(Id);
            hashMap.put("etat", "secteur supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "secteur non supprimer");
            return hashMap;
        }
    }



    // Get All secteur
    @GetMapping(value = "/GetAllsecteur")
    public List<Secteur> allSecteur() {
        return isecteur.findAll();


    }

    //Get by ID
    @GetMapping("/getbyIdsecteur/{id}")
    public Secteur getById (Long id){
        return isecteur.getOne(id);
    }
}

