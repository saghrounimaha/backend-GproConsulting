package com.pfe.com.controller;


import com.pfe.Repository.Idemandestage;
import com.pfe.Repository.Isecteur;
import com.pfe.Repository.Isociete;
import com.pfe.model.DemandeStage;
import com.pfe.model.Responsable_societe;
import com.pfe.model.Secteur;
import com.pfe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




@RestController
@RequestMapping("/societe")
@CrossOrigin("*")
public class ResponsableSocieteController {
    @Autowired
    private Isociete isociete;
    @Autowired
    private Idemandestage idemandestage;
    @Autowired
    private AccountService accountService;
    //add responsable societe
    @PostMapping(value = "/addResponsable_societe")
    public Responsable_societe createResponsable_Societe(@RequestBody Responsable_societe responsableSociete) {
        return accountService.savesociete(responsableSociete) ;

    }

    // update responsable societe
    @PutMapping("/updateResponsable_societe/{Id}")
    public Responsable_societe modif(@RequestBody Responsable_societe responsableSociete, @PathVariable Long Id) {
        Responsable_societe responsableSociete1 = isociete.getOne(Id);
        if (responsableSociete.getAdresse() == null) {
            responsableSociete.setAdresse(responsableSociete1.getAdresse());
        }
        if (responsableSociete.getConfirmerpassword() == null) {
            responsableSociete.setConfirmerpassword(responsableSociete1.getConfirmerpassword());
        }
        if (responsableSociete.getEmail() == null) {
            responsableSociete.setEmail(responsableSociete1.getEmail());
        }
        if (responsableSociete.getNom() == null) {
            responsableSociete.setNom(responsableSociete1.getNom());
        }
        if (responsableSociete.getPassword() == null) {
            responsableSociete.setPassword(responsableSociete1.getPassword());
        }
        if (responsableSociete.getPrenom() == null) {
            responsableSociete.setPrenom(responsableSociete1.getPrenom());
        }
        if (responsableSociete.getUsername() == null) {
            responsableSociete .setUsername(responsableSociete1.getUsername());
        }
        if (responsableSociete.getDescription() == null) {
            responsableSociete.setDescription(responsableSociete1.getDescription());
        }

        if (responsableSociete.getSite_web() == null) {
            responsableSociete.setSite_web(responsableSociete1.getSite_web());
        }
        if (responsableSociete.getTelephone() == null) {
            responsableSociete.setTelephone(responsableSociete1.getTelephone());
        }
        responsableSociete.setId(Id);
        return isociete.saveAndFlush(responsableSociete);
    }


    // delete resp_societe
    @DeleteMapping("/deleteResponsable_societe/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            isociete.deleteById(Id);
            hashMap.put("etat", "Responsable_societe supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "Responsable_societe non supprimer");
            return hashMap;
        }
    }



    // Get All Responsable_societe
    @GetMapping(value = "/GetAll")
    public List<Responsable_societe> allResponsable_societe() {
        return isociete.findAll();


    }

    //Get by ID
    @GetMapping("/getbyId/{id}")
    public Responsable_societe getById (Long id){
        return isociete.getOne(id);
    }

    @GetMapping("/allvalide") //liste de formation
    public List<Responsable_societe> getAllSocietevalide() {
        List<Responsable_societe> centreSocieteList = new ArrayList<>();
        for(Responsable_societe responsableSociete :isociete.findAll())
            if( responsableSociete.isEtat())
                centreSocieteList.add(responsableSociete);


        return  centreSocieteList;
    }
    @GetMapping("/allnonvalide")  //liste valide centreformation
    public List<Responsable_societe> getAllCentrenonvalide() {
        List<Responsable_societe> centreSocieteList = new ArrayList<>();
        for(Responsable_societe centreFormation :isociete.findAll())
            if( !centreFormation.isEtat())
                centreSocieteList.add(centreFormation);


        return  centreSocieteList;
    }
    @GetMapping("/vaidercentre/{id}")  // la liste des centre formation non valide
    public Responsable_societe vaidercenter(@PathVariable Long id){
        Responsable_societe responsableSociete = isociete.getOne(id);
        if(!responsableSociete.isEtat())
            responsableSociete.setEtat(true);
        return isociete.saveAndFlush(responsableSociete);
    }
    @GetMapping("/alldemandebysociete/{idcentre}")
    public List<DemandeStage> alldemandebySociete(@PathVariable Long idstage){

        List<DemandeStage> postulerList = new ArrayList<>();
        for(DemandeStage demandeStage : idemandestage.findAll())
            if(demandeStage.getStage().getResponsableSociete().getId().equals(idstage))
                postulerList.add(demandeStage);
        return postulerList;
    }
}
