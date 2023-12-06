package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Date;
import com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetListDateResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface DateRepository extends JpaRepository<Date, Integer> {

    List<Date> findByStartDate(LocalDate startDate);

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetListDateResponse (d.id, d.startDate, d.endDate, d.extendDate)" +
            "FROM Date d WHERE d.endDate BETWEEN :startDate AND :endDate ")
    List<GetListDateResponse> findByDateBetween(LocalDate startDate, LocalDate endDate);


    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetListDateResponse (d.id, d.startDate, d.endDate, d.extendDate)" +
            "FROM Date d WHERE d.extendDate IS NULL")
    List<GetListDateResponse> findByExtendDateIsNull();

}
