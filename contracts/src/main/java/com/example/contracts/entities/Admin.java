package com.example.contracts.entities;

import com.example.contracts.entities.Devise;
import com.example.contracts.entities.ParameterGlobale;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Admin extends User{
    private String matricule;
   // @Transient
    //private List<Admin> idAdmins;
    @Column(nullable = true)
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Devise> devises;
    @Column(nullable = true)
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<ParameterGlobale> parameterGlobales;
    @Column(nullable = true)
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<BO> bos;
}
