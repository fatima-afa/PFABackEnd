package com.example.contracts.entities;

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
    @Column(nullable = true)
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<Role> roles;
    @Column(nullable = true)
    @OneToMany(mappedBy = "profile", fetch = FetchType.LAZY)
    private List<User> users;

}
