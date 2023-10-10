package adria.intership.subscribers.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Profile {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String profile;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Role> roles;
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<User> users;

}
