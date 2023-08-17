package adria.internship.usersserivce.repositories;

import adria.internship.usersserivce.entities.Agence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceRepository extends JpaRepository<Agence,Long> {
}
