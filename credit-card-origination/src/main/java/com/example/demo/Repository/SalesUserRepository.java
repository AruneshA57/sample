package com.example.demo.Repository;

import com.example.demo.data.model.SalesUser;
import org.springframework.data.repository.CrudRepository;

public interface SalesUserRepository extends CrudRepository<SalesUser, Long> {

}
