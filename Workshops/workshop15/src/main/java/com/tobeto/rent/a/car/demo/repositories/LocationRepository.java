package com.tobeto.rent.a.car.demo.repositories;

import com.tobeto.rent.a.car.demo.entities.Location;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    List<Location> findByPickUpLocationEndingWith(String pickUpLocation);

    List<Location> findByDropOffLocationEndingWith(String dropOffLocation);


    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse (l.id, l.pickUpLocation, l.dropOffLocation)" +
            "FROM Location l WHERE l.pickUpLocation = 'Ankara' OR l.dropOffLocation = 'İstanbul'")
    List<GetListLocationResponse> findByPickUpOrDropOff();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse (l.id, l.pickUpLocation, l.dropOffLocation)" +
            "FROM Location l WHERE l.pickUpLocation ILIKE '%i%'")
    List<GetListLocationResponse> findByPickUpILike();

    @Query("SELECT new com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse (l.id, l.pickUpLocation, l.dropOffLocation)" +
            "FROM Location l WHERE l.dropOffLocation = 'Ankara' ORDER BY l.pickUpLocation ASC")
    List<GetListLocationResponse> findOrderByPickUp();

}
