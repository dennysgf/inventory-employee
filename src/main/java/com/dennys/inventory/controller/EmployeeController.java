package com.dennys.inventory.controller;

import com.dennys.inventory.entity.Employee;
import com.dennys.inventory.entity.Vaccine;
import com.dennys.inventory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public List<Employee> read() {
        return employeeService.listEmployee();

    }

    @GetMapping("/{id}")
    public Optional<Employee> getEmployeeById(@PathVariable(name = "id") Long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping
    public Employee update(@RequestBody Employee emp) {
        return employeeService.updateEmployee(emp);
    }

    @PostMapping
    public Employee create(@RequestBody Employee emp) {
        return employeeService.insertEmployee(emp);
    }

    @DeleteMapping
    public String delete(@PathVariable("id") Long id) {
        boolean ok = this.employeeService.deleteEmployee(id);
        if (ok) {
            return "The employee with the id: " + id + "was deleted";
        }
        return "Could not delete employee";
    }

    @PostMapping("/vaccine")
    public Vaccine createVaccine(@RequestBody Vaccine vaccine){
        return employeeService.insertVaccine(vaccine);
    }

}
