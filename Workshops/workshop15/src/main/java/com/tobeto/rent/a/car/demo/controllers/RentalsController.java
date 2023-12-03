package com.tobeto.rent.a.car.demo.controllers;

import com.tobeto.rent.a.car.demo.entities.Rental;
import com.tobeto.rent.a.car.demo.services.abstracts.RentalService;
import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.UpdateRentalRequest;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetAllRentalsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetListRentalResponse;
import com.tobeto.rent.a.car.demo.services.dtos.rental.responses.GetRentalResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rentals")
public class RentalsController {
    private final RentalService rentalService;

    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping
    public void add(@RequestBody AddRentalRequest addRentalRequest) {
        rentalService.add(addRentalRequest);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id) {
        rentalService.delete(id);
    }

    @PutMapping
    public void update(@RequestBody UpdateRentalRequest updateRentalRequest) {
        rentalService.update(updateRentalRequest);
    }

    @GetMapping("{id}")
    public GetRentalResponse getById(@PathVariable int id) {
        return rentalService.getById(id);
    }

    @GetMapping("all")
    public List<GetAllRentalsResponse> getAll() {
        return rentalService.getAll();
    }

    @GetMapping("orderByPayment")
    public List<Rental> getByOrderByPaymentId() {
        return rentalService.getByOrderByPaymentId();
    }

    @GetMapping("reservationOrderByCustomer")
    public List<GetListRentalResponse> getByReservationOrderByCustomerId() {
        return rentalService.getByReservationOrderByCustomerId();
    }
}
