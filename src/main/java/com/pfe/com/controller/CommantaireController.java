package com.pfe.com.controller;


import com.pfe.Repository.Icandidat;
import com.pfe.Repository.Icommentaire;
import com.pfe.Repository.IoffreStage;
import com.pfe.Repository.Isociete;
import com.pfe.model.Candidat;
import com.pfe.model.Commentaire;
import com.pfe.model.Offre_Stage;
import com.pfe.model.Responsable_societe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/commantaire")
@CrossOrigin("*")
public class CommantaireController {
    @Autowired
    private Icommentaire icommentaire;
@Autowired
private Icandidat  icandidat;
@Autowired
private IoffreStage ioffreStage;

    //add
    @PostMapping(value = "/addCommentaire/{idcantdiat}/{idoffrestage}")
    public Commentaire createCommentaire(@RequestBody Commentaire commentaire, @PathVariable Long idcantdiat, @PathVariable Long idoffrestage) {
        Candidat candidat=icandidat.getOne(idcantdiat);
        commentaire.setCandidat(candidat);
        Offre_Stage offreStage=ioffreStage.getOne(idoffrestage);
        return icommentaire.save(commentaire);

    }

    // update responsable societe
    @PutMapping("/updatecommentaire/{Id}")
    public Commentaire modif(@RequestBody Commentaire commentaire, @PathVariable Long Id) {
        Commentaire commentaire1 = icommentaire.getOne(Id);
        if (commentaire.getDescription() == null) {
            commentaire.setDescription(commentaire1.getDescription());
        }
        if (commentaire.getDate() == null) {
            commentaire.setDate(commentaire1.getDate());
        }

        commentaire.setId(Id);
        commentaire.setCandidat(commentaire1.getCandidat());
        return icommentaire.saveAndFlush(commentaire);
    }


    // delete resp_societe
    @DeleteMapping("/deleteResponsable_societe/{Id}")
    public HashMap<String, String> delete(@PathVariable Long Id) {
        HashMap hashMap = new HashMap();
        try {
            icommentaire.deleteById(Id);
            hashMap.put("etat", "Responsable_societe supprimer");
            return hashMap;
        } catch (Exception e) {
            hashMap.put("etat", "Responsable_societe non supprimer");
            return hashMap;
        }
    }


    // Get All Responsable_societe
    @GetMapping(value = "/GetAll")
    public List<Commentaire> allCommentaire() {
        return icommentaire.findAll();


    }

    //Get by ID
    @GetMapping("/getbyId/{id}")
    public Commentaire getById(Long id) {
        return icommentaire.getOne(id);
    }
}
