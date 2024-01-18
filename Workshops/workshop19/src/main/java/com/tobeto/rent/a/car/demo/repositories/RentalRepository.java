package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Rental;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetListRentalResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

    List<Rental> findByOrderByPaymentId();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetListRentalResponse" +
            "(r.id, " +
            "new com.tobeto.rent.a.car.demo.services.dtos.payment.responses.GetListPaymentResponse(" +
            "p.id, p.dailyPrice, p.weeklyPrice, p.monthlyPrice, " +
            "new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.phone, c.email, c.address)), " +
            "new com.tobeto.rent.a.car.demo.services.dtos.customer.responses.GetListCustomerResponse(c.id, c.phone, c.email, c.address), " +
            "new com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse(" +
            "ca.id, ca.brand, ca.model, ca.year, ca.color, ca.status, " +
            "new com.tobeto.rent.a.car.demo.services.dtos.category.responses.GetListCategoryResponse(ca.category.id, ca.category.name)), " +
            "new com.tobeto.rent.a.car.demo.services.dtos.date.responses.GetListDateResponse(" +
            "d.id, d.startDate, d.endDate, d.extendDate), " +
            "new com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse(l.id, l.pickUpLocation, l.dropOffLocation), " +
            "r.reservation)" +
            "FROM Rental r " +
            "INNER JOIN r.payment p " +
            "INNER JOIN r.customer c " +
            "INNER JOIN r.car ca " +
            "INNER JOIN ca.category cat " +  // Bu satırda "INNER JOIN r.category cat" yerine "INNER JOIN ca.category cat" kullandık.
            "INNER JOIN r.date d " +
            "INNER JOIN r.location l " +
            "WHERE r.reservation = 'Pending' ORDER BY c.id ASC ")
    List<GetListRentalResponse> findByReservationOrderByCustomerId();

}
