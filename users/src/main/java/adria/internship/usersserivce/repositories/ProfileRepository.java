package adria.internship.usersserivce.repositories;

import adria.internship.usersserivce.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile,Long> {
}
