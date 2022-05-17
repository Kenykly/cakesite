package com.university.project.repos;

import com.university.project.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

    List<Ingredient> findByTastenameAndIngtype(String name, String type);

    List<Ingredient> findByIngtype(String type);
}
