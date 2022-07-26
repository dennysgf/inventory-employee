package com.dennys.inventory.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "vaccine")
public class Vaccine {
    public enum TypeVaccine {PFIZER, ASTRAZENECA, SINOVAC}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String typeOfVaccine;

    @NotNull
    private String vaccinationDate;
    @Enumerated(EnumType.STRING)
    private TypeVaccine vaccineNumber;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @ToString.Exclude
    private Employee employee;

}
