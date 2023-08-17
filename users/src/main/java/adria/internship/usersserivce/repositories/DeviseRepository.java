package adria.internship.usersserivce.repositories;

import adria.internship.usersserivce.entities.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviseRepository extends JpaRepository<Devise,Long> {
}
