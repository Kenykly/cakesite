package com.university.project.repos;

import com.university.project.domain.Cream;
import com.university.project.domain.Filling;
import org.springframework.data.repository.CrudRepository;

public interface FillingRepository extends CrudRepository<Filling, Long> {
}
