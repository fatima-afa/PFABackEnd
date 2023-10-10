package adria.intership.subscribers.repositories;

import adria.intership.subscribers.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
