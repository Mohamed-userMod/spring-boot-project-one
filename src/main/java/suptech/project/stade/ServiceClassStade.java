package suptech.project.stade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import suptech.project.stade.dtos.Dto;
import suptech.project.stade.dtos.UpdateDto;

@Service
public class ServiceClassStade {
    @Autowired
    RepositoryInterfaceStade Stade;

    public EntityClassStade get(String id) {
        if (id != null)
            return Stade.findById(id).orElse(new EntityClassStade());

        return new EntityClassStade();

    }

    public EntityClassStade modify(String id, UpdateDto dto) {
        var entity = this.get(id);

        if (dto.nom() != null)
            entity.setNom(dto.nom());

        if (dto.pays() != null)
            entity.setPays(dto.pays());

        if (entity != null)
            return Stade.save(entity);

        return new EntityClassStade();
    }

    public EntityClassStade save(Dto data) {
        var entity = new EntityClassStade();

        entity.setNom(data.nom());
        entity.setPays(data.pays());

        return Stade.save(entity);
    }

    public List<EntityClassStade> findAll() {
        return Stade.findAll();
    }

    public EntityClassStade deleteById(String id) {
        if (id != null)
            Stade.deleteById(id);

        return new EntityClassStade();
    }
}
