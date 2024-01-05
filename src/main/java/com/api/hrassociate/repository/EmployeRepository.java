package com.api.hrassociate.repository;

import com.api.hrassociate.model.Employe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {

}
