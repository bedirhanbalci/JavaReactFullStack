package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Rental;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    List<Rental> findByOrderByPaymentId();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetListRentalResponse (r.id, r.payment, r.customer, r.car, r.date, r.location, r.reservation)" +
            "FROM Rental r " +
            "JOIN r.payment p" +
            " JOIN r.customer c" +
            " JOIN r.car ca" +
            " JOIN r.date d" +
            " JOIN r.location l" +
            " WHERE r.reservation = 'Pending' ORDER BY c.id ASC ")
    List<GetListRentalResponse> findByReservationOrderByCustomerId();

}
