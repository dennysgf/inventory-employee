package com.dennys.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="auth_user")
public class AuthUser {
    public enum Role {USER, ADMIN, USER_MANAGER}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String userName;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "authUser", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private Collection<Employee> employee;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Role role;


}
