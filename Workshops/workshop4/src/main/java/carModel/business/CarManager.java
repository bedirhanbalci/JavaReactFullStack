package carModel.business;

import java.util.List;

import carModel.core.logging.Logger;
import carModel.dataAccess.CarDao;
import carModel.entities.Car;

public class CarManager {
    private CarDao carDao;
    private List<Logger> loggers;

    public CarManager(CarDao carDao, List<Logger> loggers) {
        this.carDao = carDao;
        this.loggers = loggers;
    }


    public void add(Car car) throws Exception {
        // business rules
        if (car.getPrice() < 100000) {
            throw new Exception("Bu araç 100000 TL'den küçük olamaz!");
        }
        if (car.getProduceYear() <= 2019) {
            throw new Exception("Bu araç 2019 yılından daha eski olamaz!");
        }
        if (car.getBrand().length() < 4) {
            throw new Exception("Araba markası en az 4 harften oluşmalıdır!");
        }
        if (car.getModel().length() < 1) {
            throw new Exception(" Araba modeli en az 2 harften oluşmalıdır!");
        }
        if (car.getBrand().equals("Fiat") && car.getProduceYear() == 2024) {
            throw new Exception(" Bu marka araç henüz listemizde bulunmamaktadır!");
        }

        carDao.add(car);
        for (Logger logger : loggers) {
            logger.log(car.getBrand() + " " + car.getModel() + " " + car.getProduceYear() + " yılına ait bu araç eklendi!");
        }
    }


    public void update(Car car) {
        carDao.update(car);
        for (Logger logger : loggers) {
            logger.log(car.getBrand() + " " + car.getModel() + " " + car.getProduceYear() + " yılına ait bu araç güncellendi!");
        }
    }


    public void delete(Car car) {
        carDao.delete(car);
        for (Logger logger : loggers) {
            logger.log(car.getBrand() + " " + car.getModel() + " " + car.getProduceYear() + " yılına ait bu araç kaldırıldı!");
        }
    }
}


