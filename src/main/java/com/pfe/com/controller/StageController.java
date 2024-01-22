package com.pfe.com.controller;

import com.pfe.Repository.IoffreStage;
import com.pfe.Repository.Isecteur;
import com.pfe.Repository.Isociete;
import com.pfe.model.Offre_Stage;
import com.pfe.model.Responsable_societe;
import com.pfe.model.Secteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/offrestage")
@CrossOrigin("*")
public class StageController {
    @Autowired
    private IoffreStage ioffreStage;
    @Autowired
    private Isecteur isecteur;
    @Autowired
    private Isociete isociete;

    //add responsable societe
    @PostMapping(value = "/addoffrestage/{idsociete}/{Idsecteur}")
    public Offre_Stage createOffreStage(@RequestBody Offre_Stage offre_stage,@PathVariable Long idsociete,@PathVariable Long Idsecteur) {
        Responsable_societe responsableSociete=isociete.getOne(idsociete) ;
        offre_stage.setResponsableSociete(responsableSociete);
        offre_stage.setSecteur(isecteur.getOne(Idsecteur));
        return ioffreStage.save(offre_stage);


    }

    // update responsable societe
    @PutMapping("/updateoffrestage/{Id}")
    public Offre_Stage modif(@RequestBody Offre_Stage offre_stage, @PathVariable Long Id) {
        Offre_Stage offre_stage1 = ioffreStage.getOne(Id);
        if (offre_stage.getDate_debut() == null) {
            offre_stage.setDate_debut(offre_stage1.getDate_debut());
        }
        if (offre_stage.getDate_fin() == null) {
            offre_stage.setDate_fin(offre_stage1.getDate_fin());
        }
        if (offre_stage.getDescription() == null) {
            offre_stage.setDescription(offre_stage1.getDescription());
        }
        if (offre_stage.getDuree_stage() == null) {
            offre_stage.setDuree_stage(offre_stage1.getDuree_stage());
        }
        if (offre_stage.getNombre_stagiaire() == null) {
            offre_stage.setNombre_stagiaire(offre_stage1.getNombre_stagiaire());
        }
        if (offre_stage.getTechnologie() == null) {
            offre_stage.setTechnologie(offre_stage1.getTechnologie());
        }
        if (offre_stage.getTitre_offre() == null) {
            offre_stage.setTitre_offre(offre_stage1.getTitre_offre());
        }
        if (offre_stage.getType() == null) {
            offre_stage.setType(offre_stage1.getType());
        }

        offre_stage.setId(Id);
        offre_stage.setResponsableSociete(offre_stage1.getResponsableSociete());
        return ioffreStage.saveAndFlush(offre_stage);
    }


    // delete resp_societe
    @DeleteMapping("/deleteoffrestage/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            ioffreStage.deleteById(Id);
            hashMap.put("etat", "offre stage supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "offre stage non supprimer");
            return hashMap;
        }
    }



    // Get All offrestage
    @GetMapping(value = "/GetAlloffrestage")
    public List<Offre_Stage> allOffrestage() {
        return ioffreStage.findAll();


    }

    //Get by ID
    @GetMapping("/getbyIdoffrestage/{id}")
    public Offre_Stage getById (Long id){
        return ioffreStage.getOne(id);
    }


    @GetMapping("/allbysecteur/{idsecteur}")
    public List<Offre_Stage> getbysecteur(@PathVariable Long idsecteur ){
        Secteur secteur=isecteur.getOne(idsecteur);
        List<Offre_Stage> offre_stageList = new ArrayList<>();
        for(Offre_Stage offreStage :ioffreStage.findAll())
            if( offreStage.getSecteur().getId().equals(idsecteur))
                offre_stageList.add(offreStage);


        return  offre_stageList;

    }


    @GetMapping(value = "/allstagebyIdsociete/{idsociete}")
    public List<Offre_Stage> getAllStage(@PathVariable Long idsociete) {
        List<Offre_Stage> OffreStageList = new ArrayList<>();
        for(Offre_Stage offreStage:ioffreStage.findAll())
            if(offreStage.getResponsableSociete().getId().equals(idsociete))
                OffreStageList.add(offreStage);
        return OffreStageList;
    }
}
