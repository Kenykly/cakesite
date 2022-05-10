package com.university.project.repos;

import com.university.project.domain.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CreamRepository extends CrudRepository<Cream, Long> {

    List<Cream> findByTastename(String name);
}
