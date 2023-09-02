package adria.intership.subscribers.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Admin extends User{
    private String matricule;
    @Transient
    private List<Admin> idAdmins;
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<Devise> devises;
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<ParameterGlobale> parameterGlobales;
    @OneToMany(mappedBy = "admin", fetch = FetchType.LAZY)
    private List<BO> bos;
}
