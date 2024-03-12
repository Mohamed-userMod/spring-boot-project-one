package suptech.project.equipe;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// import suptech.project.equipe.EntityClassEquipe;
// import suptech.project.equipe.ServiceClassEquipe;
import suptech.project.equipe.dtos.Dto;
import suptech.project.equipe.dtos.UpdateDto;

@RestController
@RequestMapping("equipe")
public class ControllerEquipe {
    @Autowired
    ServiceClassEquipe Equipe;

    @PutMapping("/{id}")
    public EntityClassEquipe modifyEquipe(@RequestBody UpdateDto dto, @PathVariable String id) {
        return Equipe.modify(id, dto);
    }

    @PostMapping("")
    public EntityClassEquipe addEquipe(@RequestBody Dto EquipeDto) {
        return Equipe.save(EquipeDto);
    }

    @GetMapping("/{id}")
    public EntityClassEquipe getEquipe(@PathVariable String id) {
        return Equipe.get(id);
    }

    @GetMapping("")
    public List<EntityClassEquipe> getAllEquipes() {
        return Equipe.findAll();
    }

    @GetMapping("/search/{country}")
    public List<EntityClassEquipe> getByCountry(@PathVariable String country) {
        return Equipe.getByCountry(country);
    }

    @DeleteMapping("/{id}")
    public EntityClassEquipe deleteEquipe(@PathVariable String id) {
        return Equipe.deleteById(id);
    }
}
