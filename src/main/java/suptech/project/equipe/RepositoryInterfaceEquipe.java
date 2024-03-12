package suptech.project.equipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterfaceEquipe extends JpaRepository<EntityClassEquipe, String> {

    List<EntityClassEquipe> findByPays(String country);

    // @Query("SELECT j FROM Joueur j WHERE j.equipe_id IN (SELECT e.id FROM Equipe
    // e WHERE e.nom = :nomEquipe)")
    // List<EntityClassJoueur> findAllJoueursByNomEquipe(@Param("nomEquipe") String
    // nomEquipe);
}
