package carModel.dataAccess;

import carModel.entities.Car;

public interface CarDao {
    void add(Car car);

    void update(Car car);

    void delete(Car car);

}
