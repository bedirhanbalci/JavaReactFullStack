package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Car;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByBrandStartingWith(String brand);

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse" +
            "(c.id, c.brand, c.model, c.year, c.color, c.status, new com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse(cat.id, cat.name)) " +
            "FROM Car c INNER JOIN c.category cat WHERE c.status = 'Available' ")
    List<GetListCarResponse> findByStatus();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse" +
            " (c.id, c.brand, c.model, c.year, c.color, c.status, new com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse(cat.id, cat.name))" +
            "FROM Car c INNER JOIN c.category cat WHERE c.year > 2020 ORDER BY c.year DESC")
    List<GetListCarResponse> findOrderByYear();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse" +
            " (c.id, c.brand, c.model, c.year, c.color, c.status, new com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse(cat.id, cat.name))" +
            "FROM Car c INNER JOIN c.category cat WHERE c.brand = 'Fiat' AND c.color = 'Black' ")
    List<GetListCarResponse> findByBrandAndColor();

}
