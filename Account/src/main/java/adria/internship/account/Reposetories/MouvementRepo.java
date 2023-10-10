package adria.internship.account.Reposetories;

import adria.internship.account.entities.Mouvenemt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementRepo extends JpaRepository<Mouvenemt,Integer> {
}
