package com.tobeto.rent.a.car.demo.services.concretes;

import com.tobeto.rent.a.car.demo.entities.Car;
import com.tobeto.rent.a.car.demo.entities.Category;
import com.tobeto.rent.a.car.demo.repositories.CarRepository;
import com.tobeto.rent.a.car.demo.services.abstracts.CarService;
import com.tobeto.rent.a.car.demo.services.abstracts.CategoryService;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.AddCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.requests.UpdateCarRequest;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetAllCarsResponse;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetCarResponse;
import com.tobeto.rent.a.car.demo.services.dtos.car.responses.GetListCarResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CarManager implements CarService {

    private final CarRepository carRepository;
    private final CategoryService categoryService;

    // Her manager, yalnızca kendi entity'si için repository implementasyonu yapabilir.
    // Farklı bir entity ile çalışma gereğinde, o entity'nin service'i ile çalışılmalıdır.

    @Override
    public void add(AddCarRequest addCarRequest) {
        // Mapleme
        // Business Rule => İş Kuralı
        if (carRepository.existsCarByNumberPlate(addCarRequest.getNumberPlate())) {
            throw new RuntimeException("Aynı plaka ile 2. araba eklenemez");
        }

        if (addCarRequest.getModel().length() > 2) {
            throw new RuntimeException("Araç modeli 2 karakterden büyük olmalıdır!");
        }


        Car car = new Car();
        car.setBrand(addCarRequest.getBrand());
        car.setModel(addCarRequest.getModel());
        car.setYear(addCarRequest.getYear());
        car.setColor(addCarRequest.getColor());
        car.setStatus("Available");
        car.setNumberPlate(addCarRequest.getNumberPlate());


//        car.setCategory(addCarRequest.getCategoryId());

        // FK alanlar => FK alıp, veritabanından ilgili objeyi alarak set ederiz.

        Category category = categoryService.getById(addCarRequest.getCategoryId());
        car.setCategory(category);

        carRepository.save(car);
    }

    @Override
    public void delete(int id) {

        Car carToDelete = carRepository.findById(id).orElseThrow();
        carRepository.delete(carToDelete);
    }

    @Override
    public void update(UpdateCarRequest updateCarRequest) {

        if (updateCarRequest.getModel().length() > 2) {
            throw new RuntimeException("Araç modeli 2 karakterden büyük olmalıdır! Lütfen koşullara uygun giriş yapınız!");
        }

        Car carToUpdate = carRepository.findById(updateCarRequest.getId()).orElseThrow();
        carToUpdate.setBrand(updateCarRequest.getBrand());
        carToUpdate.setModel(updateCarRequest.getModel());
        carToUpdate.setYear(updateCarRequest.getYear());
        carToUpdate.setColor(updateCarRequest.getColor());
        carToUpdate.setStatus(updateCarRequest.getStatus());


//        carToUpdate.setCategory(updateCarRequest.getCategoryId());

        Category category = categoryService.getById(updateCarRequest.getCategoryId());
        carToUpdate.setCategory(category);

        carRepository.save(carToUpdate);
    }

    @Override
    public GetCarResponse getById(int id) {
        Car carToId = carRepository.findById(id).orElseThrow();
        GetCarResponse getCarResponse = new GetCarResponse();
        getCarResponse.setBrand(carToId.getBrand());
        getCarResponse.setModel(carToId.getModel());
        getCarResponse.setYear(carToId.getYear());
        getCarResponse.setColor(carToId.getColor());
        getCarResponse.setStatus(carToId.getStatus());
        getCarResponse.setCategoryId(carToId.getCategory());
        return getCarResponse;
    }

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> carList = carRepository.findAll();
        List<GetAllCarsResponse> getAllCarsResponseList = new ArrayList<>();
        for (Car car : carList) {
            GetAllCarsResponse getAllCarsResponse = new GetAllCarsResponse();
            getAllCarsResponse.setId(car.getId());
            getAllCarsResponse.setBrand(car.getBrand());
            getAllCarsResponse.setModel(car.getModel());
            getAllCarsResponse.setYear(car.getYear());
            getAllCarsResponse.setColor(car.getColor());
            getAllCarsResponse.setStatus(car.getStatus());
            getAllCarsResponse.setCategoryId(car.getCategory());
            getAllCarsResponseList.add(getAllCarsResponse);
        }
        return getAllCarsResponseList;
    }

    @Override
    public List<Car> getByBrand(String brand) {
        return carRepository.findByBrandStartingWith(brand);
    }

    @Override
    public List<GetListCarResponse> getByStatus() {
//        return carRepository.findByStatus();

        return carRepository.findByStatus().stream().map((car) -> {
            return new GetListCarResponse(car.getId(), car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getStatus(), car.getCategory());
        }).toList();
    }

    @Override
    public List<GetListCarResponse> getOrderByYear() {
//        return carRepository.findOrderByYear();

        return carRepository.findOrderByYear().stream().map((car) -> {
            return new GetListCarResponse(car.getId(), car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getStatus(), car.getCategory());
        }).toList();


    }

    @Override
    public List<GetListCarResponse> getByBrandAndColor() {
//        return carRepository.findByBrandAndColor();

        return carRepository.findByBrandAndColor().stream().map((car) -> {
            return new GetListCarResponse(car.getId(), car.getBrand(), car.getModel(), car.getYear(), car.getColor(), car.getStatus(), car.getCategory());
        }).toList();

    }
}
