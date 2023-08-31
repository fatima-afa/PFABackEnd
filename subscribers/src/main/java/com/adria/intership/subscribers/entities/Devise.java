package com.adria.intership.subscribers.entities;

import com.adria.intership.subscribers.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor @ToString
public class Devise {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private String code;
    private Long numero;
    private Double tauxEchange;

    @Enumerated(EnumType.STRING)
    private Statut statutDevise;
    @OneToMany(mappedBy = "devise", fetch = FetchType.LAZY)
    private  List<Pays> pays;
    @ManyToOne
    private Admin admin;


}
