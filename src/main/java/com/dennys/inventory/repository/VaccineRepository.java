package com.dennys.inventory.repository;


import com.dennys.inventory.entity.Vaccine;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepository extends CrudRepository<Vaccine,Long> {
}
