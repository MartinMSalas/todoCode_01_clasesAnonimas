package entity;

import java.util.List;

/*
 * Author: M
 * Date: 15-Mar-26
 * Project Name: Clases Anonimas
 * Description: beExcellent
 */
public class Car {

    private String id;
    private String brand;
    private String model;
    private String color;
    private double price;

    public Car(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "marca='" + brand + '\'' +
                ", modelo='" + model + '\'' +
                ", precio=" + price +
                '}';
    }


}
