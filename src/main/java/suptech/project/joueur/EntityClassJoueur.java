package suptech.project.joueur;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import suptech.project.equipe.EntityClassEquipe;

@Entity
@Table(name = "Joueur")
public class EntityClassJoueur {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String Id;

    private String nom;
    private String poste;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private EntityClassEquipe equipe;

    public String getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public EntityClassEquipe getEquipe() {
        return equipe;
    }

    public void setEquipe(EntityClassEquipe equipe) {
        this.equipe = equipe;
    }

}
