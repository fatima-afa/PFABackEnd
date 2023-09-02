package adria.intership.subscribers.repositories;

import adria.intership.subscribers.entities.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DeviseRepository extends JpaRepository<Devise,Long> {
    Optional<Devise> findByCode(String code);
}
