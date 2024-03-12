package suptech.project.arbitre;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import suptech.project.arbitre.dtos.Dto;
import suptech.project.arbitre.dtos.UpdateDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("arbitre")
public class ControllerArbitre {

    @Autowired
    ServiceClassArbitre Arbitre;

    @PutMapping("/{id}")
    public EntityClassArbitre modifyArbitre(@RequestBody UpdateDto dto, @PathVariable String id) {
        return Arbitre.modify(id, dto);
    }

    @PostMapping("")
    public EntityClassArbitre addArbitre(@RequestBody Dto ArbitreDto) {
        return Arbitre.save(ArbitreDto);
    }

    @GetMapping("/{id}")
    public EntityClassArbitre getArbitre(@PathVariable String id) {
        return Arbitre.get(id);
    }

    @GetMapping("")
    public List<EntityClassArbitre> getAllArbitres() {
        return Arbitre.findAll();
    }

    @DeleteMapping("/{id}")
    public EntityClassArbitre deleteArbitre(@PathVariable String id) {
        return Arbitre.deleteById(id);
    }

}
