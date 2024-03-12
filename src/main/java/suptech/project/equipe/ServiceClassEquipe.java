package suptech.project.equipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suptech.project.equipe.dtos.Dto;
import suptech.project.equipe.dtos.UpdateDto;

@Service
public class ServiceClassEquipe {
    @Autowired
    RepositoryInterfaceEquipe Equipe;

    public List<EntityClassEquipe> getByCountry(String country) {
        return Equipe.findByPays(country);
    }

    public EntityClassEquipe get(String id) {
        if (id != null)
            return Equipe.findById(id).orElse(new EntityClassEquipe());

        return new EntityClassEquipe();

    }

    public EntityClassEquipe modify(String id, UpdateDto dto) {
        var entity = this.get(id);

        if (dto.nom() != null)
            entity.setNom(dto.nom());

        if (dto.pays() != null)
            entity.setPays(dto.pays());

        if (entity != null)
            return Equipe.save(entity);

        return new EntityClassEquipe();
    }

    public EntityClassEquipe save(Dto data) {
        var entity = new EntityClassEquipe();

        entity.setNom(data.nom());
        entity.setPays(data.pays());

        return Equipe.save(entity);
    }

    public List<EntityClassEquipe> findAll() {
        return Equipe.findAll();
    }

    public EntityClassEquipe deleteById(String id) {
        if (id != null)
            Equipe.deleteById(id);

        return new EntityClassEquipe();
    }

}
