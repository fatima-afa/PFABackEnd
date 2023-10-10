package adria.internship.account.Reposetories;

import adria.internship.account.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepo extends JpaRepository<Compte,Long> {

}
