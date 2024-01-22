package com.pfe.com.controller;

import com.pfe.Repository.Icandidat;
import com.pfe.Repository.Idemandeformation;
import com.pfe.Repository.Iformation;
import com.pfe.model.Demandeformatin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@CrossOrigin("*")
@RestController
@RequestMapping(value = "/Demandeformation")
public class DemandeformationController {
    @Autowired
    private Idemandeformation idemandeformation;
    @Autowired
    private Icandidat icandidat;
    @Autowired
    private Iformation iformation;

    //add demande formation
    @PostMapping(value = "/adddemandeformation/{idCandida}/{idFormation}")
    public Demandeformatin createDemandefprmation(@RequestBody Demandeformatin demandeformatin, @PathVariable Long idCandida, @PathVariable Long idFormation) {
        demandeformatin.setFormation(iformation.getOne(idFormation));
        demandeformatin.setStagiaire(icandidat.getOne(idCandida));
        return idemandeformation.save(demandeformatin);

    }

    // update demandedemandeformation
    @PutMapping("/updatedemendeformation/{Id}")
    public Demandeformatin modif(@RequestBody Demandeformatin demandeformatin, @PathVariable Long Id) {
        Demandeformatin demandeformatin0 = idemandeformation.getOne(Id);
        if (demandeformatin.getCv() == null) {
            demandeformatin.setCv(demandeformatin0.getCv());
        }
        if (demandeformatin.getDate() == null) {
            demandeformatin.setDate(demandeformatin.getDate());
        }

        demandeformatin.setId(Id);
        demandeformatin.setFormation(demandeformatin0.getFormation());
        return idemandeformation.saveAndFlush(demandeformatin);
    }


    // delete demande formation
    @DeleteMapping("/deletedemendestage/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            idemandeformation.deleteById(Id);
            hashMap.put("etat", "demande supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "demande non supprimer");
            return hashMap;
        }
    }


    // Get All demende formation
    @GetMapping(value = "/GetAll")
    public List<Demandeformatin> allAdmin() {
        return idemandeformation.findAll();


    }

    //Get by ID
    @GetMapping("/getbyId/{id}")
    public Demandeformatin getById(Long id) {
        return idemandeformation.getOne(id);
    }


}
