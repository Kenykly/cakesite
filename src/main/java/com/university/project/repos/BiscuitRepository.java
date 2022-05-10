package com.university.project.repos;

import com.university.project.domain.Biscuit;
import com.university.project.domain.Message;
import com.university.project.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BiscuitRepository extends CrudRepository<Biscuit, Long> {

    List<Biscuit> findByTastename(String name);

    //Biscuit findByTastename(String username);
}
