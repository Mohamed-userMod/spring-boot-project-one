package suptech.project.joueur;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import suptech.project.joueur.dtos.Dto;
import suptech.project.joueur.dtos.UpdateDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("joueur")
public class ControllerJoueur {

    @Autowired
    ServiceClassJoueur Joueur;

    @PutMapping("/{id}")
    public EntityClassJoueur modifyJoueur(@RequestBody UpdateDto dto, @PathVariable String id) {
        return Joueur.modify(id, dto);
    }

    @PostMapping("")
    public EntityClassJoueur addJoueur(@RequestBody Dto JoueurDto) {
        return Joueur.save(JoueurDto);
    }

    @GetMapping("/{id}")
    public EntityClassJoueur getJoueur(@PathVariable String id) {
        return Joueur.get(id);
    }

    @GetMapping("/search/{nom}")
    public List<EntityClassJoueur> getByNomEquipe(@PathVariable String nom) {
        return Joueur.getByNomEquipe(nom);
    }

    @GetMapping("/search/{nom}/{poste}")
    public List<EntityClassJoueur> getByPosteAndNomEquipe(@PathVariable String poste, @PathVariable String nom) {
        return Joueur.getByPosteAndNomEquipe(poste, nom);
    }

    @GetMapping("")
    public List<EntityClassJoueur> getAllJoueurs() {
        return Joueur.findAll();
    }

    @DeleteMapping("/{id}")
    public EntityClassJoueur deleteJoueur(@PathVariable String id) {
        return Joueur.deleteById(id);
    }

}
