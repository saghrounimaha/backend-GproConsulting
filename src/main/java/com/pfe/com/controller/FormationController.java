package com.pfe.com.controller;

import com.pfe.Repository.IcentreForma;
import com.pfe.Repository.Iformation;
import com.pfe.model.Formation;
import com.pfe.model.Responsable_CentreFormation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@RestController
@RequestMapping("/formation")
@CrossOrigin("*")
public class FormationController {



        @Autowired
        private Iformation iformation;
        @Autowired
        private IcentreForma icentreForma;




        @PostMapping(value = "/add/{idcentreformation}")
        public Formation createFormation(@RequestBody Formation formation, @PathVariable Long idcentreformation) {
            Responsable_CentreFormation responsable_centreFormation = icentreForma.getOne(idcentreformation);
            formation.setResponsableCentreFormation(responsable_centreFormation);
            return iformation.save(formation);

        }

        // update  formation
        @PutMapping("/update/{Id}")
        public Formation modif(@RequestBody Formation formation, @PathVariable Long Id) {
            Formation formation0 = iformation.getOne(Id);
            if (formation.getDate_Debut() == null) {
                formation.setDate_Debut(formation0.getDate_Debut());
            }
            if (formation.getDate_Fin() == null) {
                formation.setDate_Fin(formation0.getDate_Fin());
            }
            if (formation.getDiscrepition() == null) {
                formation.setDiscrepition(formation0.getDiscrepition());
            }
            if (formation.getPhoto() == null) {
                formation.setPhoto(formation0.getPhoto());
            }
            if (formation.getPrix_Formation() == null) {
                formation.setPrix_Formation(formation0.getPrix_Formation());
            }
            if (formation.getTitre_Formation() == null) {
                formation.setTitre_Formation(formation0.getTitre_Formation());
            }
            formation.setId(Id);
            formation.setResponsableCentreFormation(formation0.getResponsableCentreFormation());
            return iformation.saveAndFlush(formation);


        }


        // delete formationg
        @DeleteMapping("/delete/{Id}")
        public HashMap<String, String> delete(@PathVariable Long Id) {
            HashMap hashMap = new HashMap();
            try {
                iformation.deleteById(Id);
                hashMap.put("etat", "Formation supprimer");
                return hashMap;
            } catch (Exception e) {
                hashMap.put("etat", "Formation non supprimer");
                return hashMap;
            }
        }


        // Get All Responsable_Formation
        @GetMapping(value = "/GetAll")
        public List<Formation> allFormation() {
            return iformation.findAll();


        }

        //Get by ID
        @GetMapping("/getbyId/{id}")
        public Formation getById(@PathVariable Long id) {
            return iformation.getOne(id);
        }


        @GetMapping(value = "/allformationbyIdCentre/{idCentre}")
        public List<Formation> getAllFormation(@PathVariable Long idCentre) {
            List<Formation> formationList = new ArrayList<>();
            for (Formation formation : iformation.findAll())
                if (formation.getResponsableCentreFormation().getId().equals(idCentre))
                    formationList.add(formation);
            return formationList;
        }
    }



