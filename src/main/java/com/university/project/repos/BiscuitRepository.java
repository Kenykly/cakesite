package com.university.project.repos;

import com.university.project.domain.Biscuit;
import org.springframework.data.repository.CrudRepository;

public interface BiscuitRepository extends CrudRepository<Biscuit, Long> {
}
