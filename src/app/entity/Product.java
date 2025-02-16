package app.entity;

import app.util.Constants;

public class Product {
    private String name;
    private int quota;
    private double price;

    public Product(String name, int quota, double price) {
        this.name = name;
        this.quota = quota;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product: " +
                "name: " + name +
                ", quota: " + quota + Constants.MEASURE_PCS +
                ", price: " + Constants.CURRENCY + " " + price + "\n";
    }
}
