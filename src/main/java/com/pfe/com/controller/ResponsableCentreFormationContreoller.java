package com.pfe.com.controller;

import com.pfe.Repository.IcentreForma;
import com.pfe.Repository.Idemandeformation;
import com.pfe.model.Demandeformatin;
import com.pfe.model.Responsable_CentreFormation;
import com.pfe.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/ResponsableCentre")
@CrossOrigin("*")

public class ResponsableCentreFormationContreoller {
    @Autowired
    private IcentreForma  icentreForma;
    @Autowired
    private  Idemandeformation idemandeformation;
    @Autowired
    private AccountService accountService;


    @PostMapping(value = "/addResponsable_CentreFormation")
    public Responsable_CentreFormation createResponsable_CentreFormation(@RequestBody Responsable_CentreFormation centreFormation) {
        return accountService.saveCenter(centreFormation);

    }

    // update  formation
    @PutMapping("/updateResponsable_CentreFormation/{Id}")
    public Responsable_CentreFormation modif(@RequestBody Responsable_CentreFormation centreFormation, @PathVariable Long Id) {
        Responsable_CentreFormation responsable_centreFormation1 = icentreForma.getOne(Id);
        if (centreFormation.getAdresse() == null) {
            centreFormation.setAdresse(responsable_centreFormation1.getAdresse());
        }
        if (centreFormation.getConfirmerpassword() == null) {
            centreFormation.setConfirmerpassword(responsable_centreFormation1.getConfirmerpassword());
        }
        if (centreFormation.getEmail() == null) {
            centreFormation.setEmail(responsable_centreFormation1.getEmail());
        }
        if (centreFormation.getNom() == null) {
            centreFormation.setNom(responsable_centreFormation1.getNom());
        }
        if (centreFormation.getPassword() == null) {
            centreFormation.setPassword(responsable_centreFormation1.getPassword());
        }
        if (centreFormation.getPrenom() == null) {
            centreFormation.setPrenom(responsable_centreFormation1.getPrenom());
        }
        if (centreFormation.getUsername() == null) {
            centreFormation.setUsername(responsable_centreFormation1.getUsername());
        }
        if (centreFormation.getDescription() == null) {
            centreFormation.setDescription(responsable_centreFormation1.getDescription());
        }

        if (centreFormation.getSiteWeb() == null) {
            centreFormation.setSiteWeb(responsable_centreFormation1.getSiteWeb());
        }
        if (centreFormation.getTelephone() == null) {
            centreFormation.setTelephone(responsable_centreFormation1.getTelephone());
        }


       centreFormation.setId(Id);
        return this.icentreForma.saveAndFlush(centreFormation);
    }


    // delete formation
    @DeleteMapping("/deleteResponsable_CentreFormation/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            this.icentreForma.deleteById(Id);
            hashMap.put("etat", "Responsable_CentreFormation supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "Responsable_CentreFormation non supprimer");
            return hashMap;
        }
    }



    // Get All Responsable_CentreFormation
    @GetMapping(value = "/GetAll")
    public List<Responsable_CentreFormation> allResponsable_CentreFormation() {
        return this.icentreForma.findAll();


    }

    //Get by ID
    @GetMapping("/getbyId/{id}")
    public Responsable_CentreFormation getById (Long id){
        return this.icentreForma.getOne(id);
    }


    @GetMapping("/allvalide") //liste de formation
    public List<Responsable_CentreFormation> getAllCentrevalide() {
        List<Responsable_CentreFormation> centreFormaList = new ArrayList<>();
        for(Responsable_CentreFormation centreFormation :this.icentreForma.findAll())
            if( centreFormation.isEtat())
                centreFormaList.add(centreFormation);


        return  centreFormaList;
    }
    @GetMapping("/allnonvalide")  //liste valide centreformation
    public List<Responsable_CentreFormation> getAllCentrenonvalide() {
        List<Responsable_CentreFormation> centreFormaList = new ArrayList<>();
        for(Responsable_CentreFormation centreFormation :this.icentreForma.findAll())
            if( !centreFormation.isEtat())
                centreFormaList.add(centreFormation);


        return  centreFormaList;
    }
    @GetMapping("/validercentre/{id}")
    public Responsable_CentreFormation vaidercenter(@PathVariable Long id){
        Responsable_CentreFormation centreFormation = this.icentreForma.getOne(id);
        if(!centreFormation.isEtat())
            centreFormation.setEtat(true);
        return this.icentreForma.saveAndFlush(centreFormation);
    }

    @GetMapping("/alldemandebycentre/{idcentre}")
    public List<Demandeformatin> alldemandebycentre(@PathVariable Long idcentre){

        List<Demandeformatin> demandeformatinList = new ArrayList<>();
        for(Demandeformatin demandeFormation : idemandeformation.findAll())
            if(demandeFormation.getFormation().getResponsableCentreFormation().getId().equals(icentreForma))
                demandeformatinList.add(demandeFormation);
        return demandeformatinList;
    }

}

