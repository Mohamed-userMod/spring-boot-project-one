package suptech.project.arbitre;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import suptech.project.match.EntityClassMatch;

@Entity
@Table(name = "Arbitre")
public class EntityClassArbitre {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String nom;
    private String nationalite;

    // @ManyToOne
    // @JoinColumn(name = "match_id")
    // private EntityClassMatch match;

    @OneToMany(mappedBy = "arbitre")
    private List<EntityClassMatch> matchs;

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

}
