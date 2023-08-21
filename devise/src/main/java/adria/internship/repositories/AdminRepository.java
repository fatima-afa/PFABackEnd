package adria.internship.repositories;

import adria.internship.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Long> {
    List<Admin> findAllByPrenomContains(String lastname);
    List<Admin> findAllByEmailContains(String email);
    List<Admin> findAllByNomContains(String name);
    List<Admin> findAllByCINContains(String cin);
    List<Admin> findAllByNomUtilisateurContains(String username);

}
