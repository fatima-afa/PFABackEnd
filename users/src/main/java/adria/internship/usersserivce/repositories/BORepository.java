package adria.internship.usersserivce.repositories;

import adria.internship.usersserivce.entities.BO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BORepository extends JpaRepository<BO,Long> {
    List<BO> findAllByPrenomContains(String lastname);
    List<BO> findAllByEmailContains(String email);
    List<BO> findAllByNomContains(String name);
    List<BO> findAllByCINContains(String cin);
    List<BO> findAllByNomUtilisateurContains(String username);
}
