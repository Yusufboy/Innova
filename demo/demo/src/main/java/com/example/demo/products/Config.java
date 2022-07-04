package com.example.demo.products;

import com.example.demo.products.outfit.Outfit;
import com.example.demo.products.outfit.OutfitRepository;
import com.example.demo.products.stationery.Stationery;
import com.example.demo.products.stationery.StationeryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Config {
    @Bean
    CommandLineRunner commandLineRunner(StationeryRepository stationeryRepository,OutfitRepository outfitRepository){
        return args -> {
            //Testing Post
            Stationery k = new Stationery("Kalem",5,1000);
            Stationery s = new Stationery("Silgi",3,2000);
            Stationery d = new Stationery("Defter",10,500);
            stationeryRepository.saveAll(List.of(k,s,d));
            Outfit t = new Outfit("Tisört",50,1000,"Small");
            Outfit p = new Outfit("Pantolon",100,2000,"Medium");
            Outfit g = new Outfit("Gomlek",200,4000,"Large");
            outfitRepository.saveAll(List.of(t,p,g));
        };
    }
}
