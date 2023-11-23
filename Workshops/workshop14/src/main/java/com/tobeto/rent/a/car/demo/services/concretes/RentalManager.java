package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Rental;
import com.tobeto.rent.a.car.demo.repositories.RentalRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.RentalService;
import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.AddRentalRequest;
import com.tobeto.rent.a.car.demo.services.dtos.rental.requests.UpdateRentalRequest;
import org.springframework.stereotype.Service;

@Service
public class RentalManager implements RentalService {
    private final RentalRepository rentalRepository;

    public RentalManager(RentalRepository rentalRepository) {
        this.rentalRepository = rentalRepository;
    }

    @Override
    public void add(AddRentalRequest addRentalRequest) {
        Rental rental = new Rental();
        rental.setPayment(addRentalRequest.getPaymentId());
        rental.setCustomer(addRentalRequest.getCustomerId());
        rental.setCar(addRentalRequest.getCarId());
        rental.setDate(addRentalRequest.getDateId());
        rental.setLocation(addRentalRequest.getLocationId());
        rental.setReservation(addRentalRequest.getReservation());
        rentalRepository.save(rental);
    }

    @Override
    public void delete(int id) {
        Rental rentalToDelete = rentalRepository.findById(id).orElseThrow();
        rentalRepository.delete(rentalToDelete);
    }

    @Override
    public void update(UpdateRentalRequest updateRentalRequest) {
        Rental rentalToUpdate = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rentalToUpdate.setPayment(updateRentalRequest.getPaymentId());
        rentalToUpdate.setCustomer(updateRentalRequest.getCustomerId());
        rentalToUpdate.setCar(updateRentalRequest.getCarId());
        rentalToUpdate.setDate(updateRentalRequest.getDateId());
        rentalToUpdate.setLocation(updateRentalRequest.getLocationId());
        rentalRepository.save(rentalToUpdate);
    }
}