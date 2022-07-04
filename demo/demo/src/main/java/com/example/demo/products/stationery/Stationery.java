package com.example.demo.products.stationery;

import com.example.demo.products.Product;

import javax.persistence.*;

@Entity
@Table(name="stationeries")
public class Stationery implements Product {
    @Id
    @SequenceGenerator(name = "stationery_sequence",
            sequenceName = "stationery_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "stationery_sequence")
    private Long id;
    private String name;
    private double price;
    private int count; // Stores the product's count in the storage

    public Stationery() {
    }

    public Stationery(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int sell(){
        this.count--;
        return this.count;
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
}