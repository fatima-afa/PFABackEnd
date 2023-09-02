package com.example.contracts.repositories;

import com.example.contracts.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat,String> {
}
