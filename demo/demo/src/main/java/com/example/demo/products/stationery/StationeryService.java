package com.example.demo.products.stationery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StationeryService {
    private final StationeryRepository stationeryRepository;

    @Autowired
    public StationeryService(StationeryRepository stationeryRepository) {
        this.stationeryRepository = stationeryRepository;
    }

    public List<Stationery> getStationeries(){
        return stationeryRepository.findAll();
    }

    public void addStationery(Stationery stationery){
        Optional<Stationery> stationeryByName = stationeryRepository.findStationeryByName(stationery.getName());
        if(stationeryByName.isPresent())
            throw new IllegalStateException("Stationery with this name exists!\n");

        stationeryRepository.save(stationery);
    }

    public void deleteStationery(Long id) {
        if(stationeryRepository.existsById(id))
            stationeryRepository.deleteById(id);
        else
            throw new IllegalStateException("Stationery not found!");
    }

    public void updateStationery(Long id,String name,double price,int count) {
        Stationery stationery = stationeryRepository.findById(id).orElseThrow(() -> new IllegalStateException("Stationery with id " + id + " don't exist!"));

        if(0 < name.length() && name != null && !Objects.equals(stationery.getName(),name))
            stationery.setName(name);
        if(0 < price)
            stationery.setPrice(price);
        if(0 < count)
            stationery.setCount(count);
    }
}
