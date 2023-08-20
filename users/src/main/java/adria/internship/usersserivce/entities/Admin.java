package adria.internship.usersserivce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Admin extends User{
    private String matricule;
   // @Transient
    //private List<Admin> idAdmins;
    //@Column(nullable = true)
    //@OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    //private List<Devise> devises;
    @Column(nullable = true)
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<ParameterGlobale> parameterGlobales;
    @Column(nullable = true)
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<BO> bos;
}
