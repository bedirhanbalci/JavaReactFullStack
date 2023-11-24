package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// Generic
// Generic Type'lar reference type olarak belirtilmelidir.
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
