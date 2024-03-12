package suptech.project.joueur;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterfaceJoueur extends JpaRepository<EntityClassJoueur, String> {

    List<EntityClassJoueur> findByEquipeNom(String nomEquipe);

    List<EntityClassJoueur> findByPosteAndEquipeNom(String poste, String nomEquipe);
}
