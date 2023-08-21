package adria.internship.repositories;

import adria.internship.entities.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviseRepository extends JpaRepository<Devise,Long> {
}
