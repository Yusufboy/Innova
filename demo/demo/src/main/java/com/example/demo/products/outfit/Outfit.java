package com.example.demo.products.outfit;

import com.example.demo.products.Product;

import javax.persistence.*;

@Entity
@Table(name="outfits")
public class Outfit implements Product {
    @Id
    @SequenceGenerator(name = "outfit_sequence",
            sequenceName = "outfit_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "outfit_sequence")
    private Long id;
    private String name;
    private double price;
    private int count; // Stores the product's count in the storage
    private String size;

    public Outfit() {
    }

    public Outfit(String name, int price, int count,String size) {
        this.name = name;
        this.price = price;
        this.count = count;
        this.size = size;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", size=" + size +
                '}';
    }
}
