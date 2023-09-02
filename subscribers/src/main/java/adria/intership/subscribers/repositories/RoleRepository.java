package adria.intership.subscribers.repositories;

import adria.intership.subscribers.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
