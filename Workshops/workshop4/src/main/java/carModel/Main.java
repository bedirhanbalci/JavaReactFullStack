package carModel;

import carModel.business.CarManager;
import carModel.core.logging.DatabaseLogger;
import carModel.core.logging.FileLogger;
import carModel.core.logging.Logger;
import carModel.core.logging.MailLogger;
import carModel.dataAccess.HibernateCarDao;
import carModel.dataAccess.JdbcCarDao;
import carModel.entities.Car;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car1 = new Car(1, 2020, 150000, "Peugeot ", "3008");
        Car car2 = new Car(2, 2022, 300000, "Volvo", "EX30");
        Car car3 = new Car(3, 2021, 200000, "Mercedes", "GLC300");
        Car car4 = new Car(4, 2023, 250000, "Audi", "Q8");
        //Car car5 = new Car(5, 2024, 175000, "Fiat", "EgeaSuv");

        List<Logger> loggers = new ArrayList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());
        loggers.add(new MailLogger());

        CarManager carManager = new CarManager(new HibernateCarDao(), loggers);
        carManager.add(car1);
        carManager.update(car1);
        carManager.delete(car1);
        System.out.println("----------------------------------------------------");
        carManager.add(car2);
        carManager.update(car2);
        carManager.delete(car2);
        System.out.println("----------------------------------------------------");
        carManager.add(car3);
        carManager.update(car3);
        carManager.delete(car3);
        System.out.println("----------------------------------------------------");
        carManager.add(car4);
        carManager.update(car4);
        carManager.delete(car4);
        System.out.println("----------------------------------------------------");
//        carManager.add(car5);
//        carManager.update(car5);
//        carManager.delete(car5);


    }
}