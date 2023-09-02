package adria.intership.subscribers.repositories;

import adria.intership.subscribers.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
