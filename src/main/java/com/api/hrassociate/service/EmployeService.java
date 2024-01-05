package com.api.hrassociate.service;

import com.api.hrassociate.model.Employe;
import com.api.hrassociate.repository.EmployeRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class EmployeService {


    private EmployeRepository employeRepository;

    public Optional<Employe> getEmployee(final Long id){
        return employeRepository.findById(id);
    }
    /* Optional<> gère le cas où la valeur retournée est nulle c'est une classe btw*/

    public Iterable<Employe> getEmployees(){
        return employeRepository.findAll();
    }
    /* Iterable pour une liste d'objets Employee*/

    public void deleteEmployee(final Long id){
        employeRepository.deleteById(id);
    }

    public Employe saveEmployee(Employe employe){
        return employeRepository.save(employe);
    }

    /* Ajouter final aux paramètres des fonctions pourrait le rendre immuable(read-only) */
}
