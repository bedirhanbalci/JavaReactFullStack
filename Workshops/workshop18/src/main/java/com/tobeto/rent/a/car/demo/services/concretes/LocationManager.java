package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Location;
import com.tobeto.rent.a.car.demo.repositories.LocationRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.LocationService;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.AddLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.UpdateLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetAllLocationsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetLocationResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class LocationManager implements LocationService {

    private final LocationRepository locationRepository;

    @Override
    public void add(AddLocationRequest addLocationRequest) {

        if (locationRepository.existsLocationByPickUpLocationStartingWith(addLocationRequest.getPickUpLocation())) {
            throw new RuntimeException("Aynı ön ek ile başlayan şehirler olamaz!");
        }

        if (locationRepository.existsByDropOffLocationEndingWith(addLocationRequest.getDropOffLocation())) {
            throw new RuntimeException("Aynı son ek ile biten şehirler olamaz!");
        }

        if (addLocationRequest.getPickUpLocation().length() > 3) {
            throw new RuntimeException("Şehir ismi 3 karakterden büyük olmalıdır!");
        }

        if (addLocationRequest.getDropOffLocation().length() > 3) {
            throw new RuntimeException("Şehir ismi 3 karakterden büyük olmalıdır!");
        }

        Location location = new Location();
        location.setPickUpLocation(addLocationRequest.getPickUpLocation());
        location.setDropOffLocation(addLocationRequest.getDropOffLocation());
        locationRepository.save(location);
    }

    @Override
    public void delete(int id) {
        Location locationToDelete = locationRepository.findById(id).orElseThrow();
        locationRepository.delete(locationToDelete);
    }

    @Override
    public void update(UpdateLocationRequest updateLocationRequest) {

        if (updateLocationRequest.getPickUpLocation().length() > 3) {
            throw new RuntimeException("Şehir ismi 3 karakterden büyük olmalıdır!");
        }

        if (updateLocationRequest.getDropOffLocation().length() > 3) {
            throw new RuntimeException("Şehir ismi 3 karakterden büyük olmalıdır!");
        }


        Location locationToUpdate = locationRepository.findById(updateLocationRequest.getId()).orElseThrow();
        locationToUpdate.setPickUpLocation(updateLocationRequest.getPickUpLocation());
        locationToUpdate.setDropOffLocation(updateLocationRequest.getDropOffLocation());
        locationRepository.save(locationToUpdate);
    }

    @Override
    public GetLocationResponse getById(int id) {
        Location locationToId = locationRepository.findById(id).orElseThrow();
        GetLocationResponse getLocationResponse = new GetLocationResponse();
        getLocationResponse.setPickUpLocation(locationToId.getPickUpLocation());
        getLocationResponse.setDropOffLocation(locationToId.getDropOffLocation());
        return getLocationResponse;
    }

    @Override
    public List<GetAllLocationsResponse> getAll() {
        List<Location> locationList = locationRepository.findAll();
        List<GetAllLocationsResponse> getAllLocationsResponseList = new ArrayList<>();
        for (Location location : locationList) {
            GetAllLocationsResponse getAllLocationsResponse = new GetAllLocationsResponse();
            getAllLocationsResponse.setId(location.getId());
            getAllLocationsResponse.setPickUpLocation(location.getPickUpLocation());
            getAllLocationsResponse.setDropOffLocation(location.getDropOffLocation());
            getAllLocationsResponseList.add(getAllLocationsResponse);
        }
        return getAllLocationsResponseList;
    }

    @Override
    public List<Location> getByPickUp(String pickUpLocation) {
        return locationRepository.findByPickUpLocationEndingWith(pickUpLocation);
    }

    @Override
    public List<Location> getByDropOff(String dropOffLocation) {
        return locationRepository.findByDropOffLocationEndingWith(dropOffLocation);
    }

    @Override
    public List<GetListLocationResponse> getByPickUpOrDropOff() {
//        return locationRepository.findByPickUpOrDropOff();

        return locationRepository.findByPickUpOrDropOff().stream().map((location) -> {
            return new GetListLocationResponse(location.getId(), location.getPickUpLocation(), location.getDropOffLocation());
        }).toList();
    }

    @Override
    public List<GetListLocationResponse> getByPickUpILike() {
//        return locationRepository.findByPickUpILike();

        return locationRepository.findByPickUpILike().stream().map((location) -> {
            return new GetListLocationResponse(location.getId(), location.getPickUpLocation(), location.getDropOffLocation());
        }).toList();
    }

    @Override
    public List<GetListLocationResponse> getByOrderByPickUp() {
//        return locationRepository.findByOrderByPickUp();

        return locationRepository.findByOrderByPickUp().stream().map((location) -> {
            return new GetListLocationResponse(location.getId(), location.getPickUpLocation(), location.getDropOffLocation());
        }).toList();
    }
}