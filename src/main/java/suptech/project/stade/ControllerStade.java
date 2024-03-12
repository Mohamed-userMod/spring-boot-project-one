package suptech.project.stade;

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

import suptech.project.stade.dtos.Dto;
import suptech.project.stade.dtos.UpdateDto;

@RestController
@RequestMapping("stade")
public class ControllerStade {
    @Autowired
    ServiceClassStade Stade;

    @PutMapping("/{id}")
    public EntityClassStade modifyStade(@RequestBody UpdateDto dto, @PathVariable String id) {
        return Stade.modify(id, dto);
    }

    @PostMapping("")
    public EntityClassStade addStade(@RequestBody Dto StadeDto) {
        return Stade.save(StadeDto);
    }

    @GetMapping("/{id}")
    public EntityClassStade getStade(@PathVariable String id) {
        return Stade.get(id);
    }

    @GetMapping("")
    public List<EntityClassStade> getAllStades() {
        return Stade.findAll();
    }

    @DeleteMapping("/{id}")
    public EntityClassStade deleteStade(@PathVariable String id) {
        return Stade.deleteById(id);
    }
}
