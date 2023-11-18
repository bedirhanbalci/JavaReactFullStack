package carModel.dataAccess;

import carModel.entities.Car;


public class HibernateCarDao implements CarDao {
    @Override
    public void add(Car car) {
        System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getProduceYear() + " Hibernate ile veritabanına eklendi! ");
    }

    @Override
    public void update(Car car) {
        System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getProduceYear() + " Hibernate ile veritabanında güncellendi! ");
    }

    @Override
    public void delete(Car car) {
        System.out.println(car.getBrand() + " " + car.getModel() + " " + car.getProduceYear() + " Hibernate ile veritabanından silindi! ");
    }


}
