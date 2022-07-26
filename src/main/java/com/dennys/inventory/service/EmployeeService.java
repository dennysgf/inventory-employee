package com.dennys.inventory.service;

import com.dennys.inventory.entity.AuthUser;
import com.dennys.inventory.entity.Employee;
import com.dennys.inventory.entity.Vaccine;
import com.dennys.inventory.repository.AuthUserRepository;
import com.dennys.inventory.repository.EmployeeRepository;
import com.dennys.inventory.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employee;
    @Autowired
    AuthUserRepository authUSer;

    @Autowired
    VaccineRepository vaccine;

    public Employee insertEmployee(Employee emp) {
        return employee.save(emp);
    }

    public AuthUser insertUser(AuthUser authUser) {
        return authUSer.save(authUser);
    }

    public Employee updateEmployee(Employee emp) {
        return employee.save(emp);
    }

    public List<Employee> listEmployee() {
        return (List<Employee>) employee.findAll();
    }

    public Optional<Employee> getEmployeeById(Long number){
        return employee.findById(number);
    }

    public Vaccine insertVaccine(Vaccine emp) {
        return vaccine.save(emp);
    }

    public boolean deleteEmployee(Long id) {
        try {
            employee.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }
}
