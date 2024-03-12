package suptech.project.match;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

import suptech.project.arbitre.EntityClassArbitre;
import suptech.project.equipe.EntityClassEquipe;
import suptech.project.match.dtos.Dto;
import suptech.project.match.dtos.UpdateDto;
import suptech.project.stade.EntityClassStade;

@Service
public class ServiceClassMatch {
    @Autowired
    RepositoryInterfaceMatch Match;

    public List<EntityClassMatch> findByDate(LocalDateTime date) {
        return Match.findByDate(date);
    }

    public void deletePassed(LocalDateTime date) {
        Match.deleteByDateBefore(date);
    }

    public EntityClassStade getStade(String id) {
        if (id != null)
            return Match.findById(id).orElse(new EntityClassMatch()).getStade();

        return new EntityClassMatch().getStade();
    }

    public List<EntityClassEquipe> getTwoEquipes(String id) {
        List<EntityClassEquipe> equipes = new ArrayList<>();

        if (id != null) {
            EntityClassMatch match = Match.findById(id).orElse(new EntityClassMatch());
            equipes.add(match.getEquipe1());
            equipes.add(match.getEquipe2());
        }

        return equipes;
    }

    public EntityClassMatch get(String id) {
        if (id != null)
            return Match.findById(id).orElse(new EntityClassMatch());

        return new EntityClassMatch();

    }

    public EntityClassMatch modify(String id, UpdateDto dto) {
        var entity = this.get(id);

        // var stade = new EntityClassStade();
        // var equipe_1 = new EntityClassEquipe();
        // var equipe_2 = new EntityClassEquipe();
        // var arbitre = new EntityClassArbitre();

        // stade.setId(dto.stade_id());
        // arbitre.setId(dto.arbitre_id());
        // equipe_1.setId(dto.equipe_1_id());
        // equipe_2.setId(dto.equipe_2_id());

        if (dto.date() != null)
            entity.setDate(dto.date());

        if (dto.time() != null)
            entity.setTime(dto.time());

        // if (dto.stade_id() != null)
        // entity.setStade(stade);

        // if (dto.arbitre_id() != null)
        // entity.setArbitre(arbitre);

        // if (dto.equipe_1_id() != null)
        // entity.setEquipe1(equipe_1);

        // if (dto.time() != null)
        // entity.setEquipe2(equipe_2);

        if (entity != null)
            return Match.save(entity);

        return new EntityClassMatch();
    }

    public EntityClassMatch save(Dto data) {
        var entity = new EntityClassMatch();
        var stade = new EntityClassStade();
        var equipe_1 = new EntityClassEquipe();
        var equipe_2 = new EntityClassEquipe();
        var arbitre = new EntityClassArbitre();

        stade.setId(data.stade_id());
        arbitre.setId(data.arbitre_id());
        equipe_1.setId(data.equipe_1_id());
        equipe_2.setId(data.equipe_2_id());

        entity.setStade(stade);
        entity.setArbitre(arbitre);
        entity.setDate(data.date());
        entity.setTime(data.time());
        entity.setEquipe1(equipe_1);
        entity.setEquipe2(equipe_2);

        return Match.save(entity);
    }

    public List<EntityClassMatch> findAll() {
        return Match.findAll();
    }

    public EntityClassMatch deleteById(String id) {
        if (id != null)
            Match.deleteById(id);

        return new EntityClassMatch();
    }
}
