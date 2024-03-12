package suptech.project.match;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.transaction.Transactional;

@Repository
public interface RepositoryInterfaceMatch extends JpaRepository<EntityClassMatch, String> {

    List<EntityClassMatch> findByDate(LocalDateTime date);

    @Transactional
    void deleteByDateBefore(LocalDateTime currentDate);

    // Match findById(Long stadeId);
    // @Query("SELECT m FROM Match m WHERE m.date = :date")
    // List<EntityClassMatch> findMatchsByDate(@Param("date") Date dateMatch);

    // @Query("SELECT e1, e2 FROM Match m JOIN Equipe e1 ON m.equipe_2_id = e1.id
    // JOIN Equipe e2 ON m.equipe_2_id = e2.id WHERE m.id = :matchId")
    // Object[] findEquipesByMatchId(@Param("matchId") Long matchId);
}
