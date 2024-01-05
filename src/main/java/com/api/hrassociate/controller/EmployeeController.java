package com.api.hrassociate.controller;


import com.api.hrassociate.model.Employe;
import com.api.hrassociate.service.EmployeService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class EmployeeController {
    private EmployeService employeService;

    @GetMapping("/employees")
    public Iterable<Employe> getEmployees(){
        return employeService.getEmployees();
    }

    @GetMapping("employees/{id}")
    public Optional<Employe> getEmployee(@PathVariable("id") final Long id){
        return employeService.getEmployee(id);
    }

    @PostMapping("/add")
    public Employe addEmployee(@RequestBody Employe employee){
        return employeService.saveEmployee(employee);
    }

    @PutMapping("/add/{id}")
    public Employe updateEmployee(@PathVariable("id") Long id, @RequestBody Employe employee){
        Optional<Employe> optionalEmployee = employeService.getEmployee(id);

        if(optionalEmployee.isPresent()){
            Employe currEmployee = optionalEmployee.get();

            String firstname = employee.getFirst_name();
            if(firstname != null){
                currEmployee.setFirst_name(firstname);
            }
            String lastname = employee.getLast_name();
            if(lastname != null){
                currEmployee.setLast_name(lastname);
            }
            String mail = employee.getMail();
            if(mail != null){
                currEmployee.setMail(mail);
            }
            String password = employee.getPassword();
            if(password != null){
                currEmployee.setPassword(password);
            }
            employeService.saveEmployee(currEmployee);
            return currEmployee;
        }else{
            return null;
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id") final Long id){
        employeService.deleteEmployee(id);
    }
}
