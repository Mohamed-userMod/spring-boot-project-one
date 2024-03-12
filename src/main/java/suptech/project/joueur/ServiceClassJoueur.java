package suptech.project.joueur;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import suptech.project.equipe.EntityClassEquipe;
import suptech.project.joueur.dtos.Dto;
import suptech.project.joueur.dtos.UpdateDto;

@Service
public class ServiceClassJoueur {

    @Autowired
    RepositoryInterfaceJoueur Joueur;

    public List<EntityClassJoueur> getByNomEquipe(String nom) {
        return Joueur.findByEquipeNom(nom);
    }

    public List<EntityClassJoueur> getByPosteAndNomEquipe(String poste, String nom) {
        return Joueur.findByPosteAndEquipeNom(poste, nom);
    }

    public EntityClassJoueur get(String id) {
        if (id != null)
            return Joueur.findById(id).orElse(new EntityClassJoueur());

        return new EntityClassJoueur();

    }

    public EntityClassJoueur modify(String id, UpdateDto dto) {
        var entity = this.get(id);

        if (dto.nom() != null)
            entity.setNom(dto.nom());

        if (dto.poste() != null)
            entity.setPoste(dto.poste());

        if (entity != null) {
            return Joueur.save(entity);
        } else {
            return new EntityClassJoueur();
        }
    }

    public EntityClassJoueur save(Dto data) {
        var entity = new EntityClassJoueur();

        entity.setNom(data.nom());
        entity.setPoste(data.poste());

        var equipe = new EntityClassEquipe();
        equipe.setId(data.equipe_id());

        entity.setEquipe(equipe);

        return Joueur.save(entity);
    }

    public List<EntityClassJoueur> findAll() {
        return Joueur.findAll();
    }

    public EntityClassJoueur deleteById(String id) {
        if (id != null)
            Joueur.deleteById(id);

        return new EntityClassJoueur();
    }

}
