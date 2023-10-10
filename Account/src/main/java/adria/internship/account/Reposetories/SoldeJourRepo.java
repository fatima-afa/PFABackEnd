package adria.internship.account.Reposetories;

import adria.internship.account.entities.SoldeJournal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldeJourRepo extends JpaRepository<SoldeJournal, Integer> {
}
