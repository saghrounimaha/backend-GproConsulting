package com.pfe.com.controller;

import com.pfe.Repository.Icandidat;
import com.pfe.Repository.Idemandestage;
import com.pfe.Repository.Istage;
import com.pfe.model.DemandeStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/DemandeStage")
public class DemandeStageController {
    @Autowired
    private Idemandestage idemandestage;
    @Autowired
    private Istage istage;
    @Autowired
    private Icandidat icandidat;

    //add admin
    @PostMapping(value = "/adddemandestage/{idstage}/{idCandiat}")
    public DemandeStage createDemandeStage(@RequestBody DemandeStage demandeStage, @PathVariable Long idstage, @PathVariable Long idCandiat) {
        demandeStage.setStage(istage.getOne(idstage));
        demandeStage.setStagiaire(icandidat.getOne(idCandiat));
        return idemandestage.save(demandeStage);

    }

    // update demandestage
    @PutMapping("/updatedemandestage/{Id}")
    public DemandeStage modif(@RequestBody DemandeStage demandeStage, @PathVariable Long Id) {
        demandeStage.setId(Id);
        return idemandestage.saveAndFlush(demandeStage);
    }


    // delete demande stage
    @DeleteMapping("/deletedemendestage/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            idemandestage.deleteById(Id);
            hashMap.put("etat", "demande supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "demande non supprimer");
            return hashMap;
        }
    }


    // Get All demende stage
    @GetMapping(value = "/GetAll")
    public List<DemandeStage> allAdmin() {
        return idemandestage.findAll();


    }

    //Get by ID
    @GetMapping("/getbyId/{id}")
    public DemandeStage getById(Long id) {
        return idemandestage.getOne(id);
    }

    @GetMapping("/all/{id}")
    public List<DemandeStage> post(@PathVariable Long id) {
        List<DemandeStage> postulerList = new ArrayList<>();
        for (DemandeStage postuler : idemandestage.findAll())
            if (postuler.getStage().getResponsableSociete().getId().equals(id))
                postulerList.add(postuler);
        return postulerList;
    }

}

