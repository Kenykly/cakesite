package com.university.project.repos;

import com.university.project.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface MessageRepository  extends CrudRepository<Message, Long>{

    //https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html#jpa.query-methods.query-creation
    List<Message> findByTag(String tag);


}
