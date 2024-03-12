package suptech.project.match;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import suptech.project.arbitre.EntityClassArbitre;
import suptech.project.equipe.EntityClassEquipe;
import suptech.project.stade.EntityClassStade;

@Entity
@Table(name = "`Match`")
public class EntityClassMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    public EntityClassArbitre getArbitre() {
        return arbitre;
    }

    public void setArbitre(EntityClassArbitre arbitre) {
        this.arbitre = arbitre;
    }

    public EntityClassStade getStade() {
        return stade;
    }

    public void setStade(EntityClassStade stade) {
        this.stade = stade;
    }

    public EntityClassEquipe getEquipe1() {
        return equipe1;
    }

    public void setEquipe1(EntityClassEquipe equipe1) {
        this.equipe1 = equipe1;
    }

    public EntityClassEquipe getEquipe2() {
        return equipe2;
    }

    public void setEquipe2(EntityClassEquipe equipe2) {
        this.equipe2 = equipe2;
    }

    private LocalDateTime date;

    private Time time;

    @ManyToOne
    @JoinColumn(name = "arbitre_id")
    private EntityClassArbitre arbitre;

    @ManyToOne
    @JoinColumn(name = "stade_id")
    private EntityClassStade stade;

    @ManyToOne
    @JoinColumn(name = "equipe_1_id")
    private EntityClassEquipe equipe1;

    @ManyToOne
    @JoinColumn(name = "equipe_2_id")
    private EntityClassEquipe equipe2;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
