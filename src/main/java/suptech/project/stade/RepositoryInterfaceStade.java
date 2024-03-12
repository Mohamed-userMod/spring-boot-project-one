package suptech.project.stade;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterfaceStade extends JpaRepository<EntityClassStade, String> {

}
