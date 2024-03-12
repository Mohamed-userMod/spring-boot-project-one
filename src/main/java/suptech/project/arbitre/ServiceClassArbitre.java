package suptech.project.arbitre;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import suptech.project.arbitre.dtos.Dto;
import suptech.project.arbitre.dtos.UpdateDto;

@Service
public class ServiceClassArbitre {

    @Autowired
    RepositoryInterfaceArbitre Arbitre;

    public EntityClassArbitre get(String id) {
        if (id != null)
            return Arbitre.findById(id).orElse(new EntityClassArbitre());

        return new EntityClassArbitre();

    }

    public EntityClassArbitre modify(String id, UpdateDto dto) {
        var entity = this.get(id);

        if (dto.nom() != null)
            entity.setNom(dto.nom());

        if (dto.nationalite() != null)
            entity.setNationalite(dto.nationalite());

        if (entity != null)
            return Arbitre.save(entity);

        return new EntityClassArbitre();
    }

    public EntityClassArbitre save(Dto data) {
        var entity = new EntityClassArbitre();

        entity.setNom(data.nom());
        entity.setNationalite(data.nationalite());

        return Arbitre.save(entity);
    }

    public List<EntityClassArbitre> findAll() {
        return Arbitre.findAll();
    }

    public EntityClassArbitre deleteById(String id) {
        if (id != null)
            Arbitre.deleteById(id);

        return new EntityClassArbitre();
    }

}
