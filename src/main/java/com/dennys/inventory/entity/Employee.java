package com.dennys.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 10)
    @NotEmpty(message = "The identification cannot be empty")
    private String identification;
    @Column(nullable = false)
    @Pattern(regexp = "([A-Za-z]+@[a-z]+\\.[a-z])")
    private String name;
    @Column(nullable = false)
    @Pattern(regexp = "([A-Za-z]+@[a-z]+\\.[a-z])")
    private String lastName;
    @Column(nullable = false)
    @NotEmpty(message = "Email cannot be empty")
    @Email(message = "email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    private String emailAddress;
    @Column()
    private String dateOfBirth;
    @Column()
    private String homeAddress;
    @Column()
    private boolean statusOfVaccine;
    @Column()
    private String PhoneNumber;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private AuthUser authUser;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @ToString.Exclude
    private Collection<Vaccine> vaccine;


}
