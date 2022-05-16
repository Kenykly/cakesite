package com.university.project.repos;

import com.university.project.domain.Message;
import com.university.project.domain.Order;
import com.university.project.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    Order findById(int id);

    List<Order> findByUserId(long id);
}
