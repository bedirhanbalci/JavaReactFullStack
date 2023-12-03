package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Location;
import com.tobeto.rent.a.car.demo.repositories.LocationRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.LocationService;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.AddLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.requests.UpdateLocationRequest;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetAllLocationsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetListLocationResponse;
import com.tobeto.rent.a.car.demo.services.dtos.location.responses.GetLocationResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationManager implements LocationService {

    private final LocationRepository locationRepository;

    public LocationManager(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void add(AddLocationRequest addLocationRequest) {
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
        return locationRepository.findByPickUpOrDropOff();
    }

    @Override
    public List<GetListLocationResponse> getByPickUpILike() {
        return locationRepository.findByPickUpILike();
    }

    @Override
    public List<GetListLocationResponse> getOrderByPickUp() {
        return locationRepository.findOrderByPickUp();
    }
}