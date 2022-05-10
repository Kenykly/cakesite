package com.university.project.repos;

import com.university.project.domain.Biscuit;
import com.university.project.domain.Cream;
import com.university.project.domain.Filling;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FillingRepository extends CrudRepository<Filling, Long> {

    List<Filling> findByTastename(String name);
}
