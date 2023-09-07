package adria.intership.subscribers.repositories;

import adria.intership.subscribers.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,String> {
}
