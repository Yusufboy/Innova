package com.example.demo.products.stationery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StationeryController {
    private final StationeryService stationeryService;

    @Autowired
    public StationeryController(StationeryService stationeryService) {
        this.stationeryService = stationeryService;
    }

    @GetMapping(value = "/getStationeries")
    public List<Stationery> getStationeries(){
        return stationeryService.getStationeries();
    }

    @PostMapping(value = "/addStationery")
    public void addStationery(@RequestBody Stationery stationery){stationeryService.addStationery(stationery);}

    @DeleteMapping(path="{stationeryId}")
    public void deleteStationery(@PathVariable("stationeryId") Long id){stationeryService.deleteStationery(id);}

    @PutMapping(path="{stationeryId}")
    public void updateStationery(
            @PathVariable("stationeryId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) int count){stationeryService.updateStationery(id,name,price,count);}
}
