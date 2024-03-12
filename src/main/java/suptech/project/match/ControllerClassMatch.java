package suptech.project.match;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonFormat;

import suptech.project.equipe.EntityClassEquipe;
import suptech.project.match.dtos.Dto;
import suptech.project.match.dtos.UpdateDto;
import suptech.project.stade.EntityClassStade;

@RestController
@RequestMapping("match")
public class ControllerClassMatch {
    @Autowired
    ServiceClassMatch Match;

    @PutMapping("/{id}")
    public EntityClassMatch modifyMatch(@RequestBody UpdateDto dto, @PathVariable String id) {
        return Match.modify(id, dto);
    }

    @PostMapping("")
    public EntityClassMatch addMatch(@RequestBody Dto MatchDto) {
        return Match.save(MatchDto);
    }

    @GetMapping("/{id}")
    public EntityClassMatch getMatch(@PathVariable String id) {
        return Match.get(id);
    }

    @GetMapping("/get-stade/{id}")
    public EntityClassStade getStade(@PathVariable String id) {
        return Match.getStade(id);
    }

    @GetMapping("/get-opponents/{id}")
    public List<EntityClassEquipe> getOpponents(@PathVariable String id) {
        return Match.getTwoEquipes(id);
    }

    @GetMapping("")
    public List<EntityClassMatch> getAllMatchs() {
        return Match.findAll();
    }

    @GetMapping("/search-date")
    public List<EntityClassMatch> getMatchByDate(
            @RequestParam @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDateTime date) {
        return Match.findByDate(date);
    }

    @DeleteMapping("/{id}")
    public EntityClassMatch deleteMatch(@PathVariable String id) {
        return Match.deleteById(id);
    }

    @DeleteMapping("/passed")
    public void deleteMatchBefore() {
        Match.deletePassed(LocalDateTime.now());
    }

}
