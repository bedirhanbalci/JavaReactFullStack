package carModel.entities;

public class Car {

    private int id;
    private int produceYear;
    private double price;
    private String brand;
    private String model;

    public Car() {

    }

    public Car(int id, int produceYear, double price, String brand, String model) {
        this.id = id;
        this.produceYear = produceYear;
        this.price = price;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(int produceYear) {
        this.produceYear = produceYear;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
