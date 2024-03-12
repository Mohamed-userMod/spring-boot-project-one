package suptech.project.arbitre;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryInterfaceArbitre extends JpaRepository<EntityClassArbitre, String> {

}
