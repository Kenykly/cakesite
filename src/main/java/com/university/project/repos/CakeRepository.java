package com.university.project.repos;

import com.university.project.domain.Cake;
import com.university.project.domain.Message;
import com.university.project.domain.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CakeRepository extends CrudRepository<Cake, Long> {

   Cake findById(int id);


   @Query("select c from Cake c where c.isInBasket = true  and c.user.id=?1")
   List<Cake> findByUserIdAndisInBasket(long id);
}
