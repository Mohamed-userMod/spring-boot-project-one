package suptech.project.equipe;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import suptech.project.joueur.EntityClassJoueur;

@Entity
@Table(name = "Equipe")
public class EntityClassEquipe {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String nom;
    private String pays;

    @OneToMany(mappedBy = "equipe")
    private List<EntityClassJoueur> joueurs;

    // @OneToOne
    // private EntityClassMatch match;

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

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

}
