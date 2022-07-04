package com.example.demo.products;

public interface Product {
    int sell();
    void setName(String name);
    String getName();
    void setPrice(double price);
    double getPrice();
    void setCount(int count);
    int getCount();
}
