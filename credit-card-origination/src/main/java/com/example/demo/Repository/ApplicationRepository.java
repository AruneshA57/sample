package com.example.demo.Repository;

import com.example.demo.data.model.Applications;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationRepository extends CrudRepository<Applications,Long> {

}
