package adria.internship.repositories;

import adria.internship.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence,Long> {
}
