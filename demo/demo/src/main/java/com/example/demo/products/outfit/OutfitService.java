package com.example.demo.products.outfit;

import com.example.demo.products.outfit.Outfit;
import com.example.demo.products.outfit.OutfitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class OutfitService {
    private final OutfitRepository outfitRepository;

    @Autowired
    public OutfitService(OutfitRepository outfitRepository) {
        this.outfitRepository = outfitRepository;
    }

    public List<Outfit> getOutfits(){
        return outfitRepository.findAll();
    }

    public void addOutfit(Outfit outfit){
        Optional<Outfit> outfitByName = outfitRepository.findOutfitByName(outfit.getName());
        if(outfitByName.isPresent() && outfitByName.equals(outfit))
            throw new IllegalStateException("Outfit with this name exists!\n");

        outfitRepository.save(outfit);
    }

    public void deleteOutfit(Long id) {
        if(outfitRepository.existsById(id))
            outfitRepository.deleteById(id);
        else
            throw new IllegalStateException("Outfit not found!");
    }

    public void updateOutfit(Long id,String name,double price,int count,String size) {
        Outfit outfit = outfitRepository.findById(id).orElseThrow(() -> new IllegalStateException("Outfit with id " + id + " don't exist!"));

        if(0 < name.length() && name != null && !Objects.equals(outfit.getName(),name))
            outfit.setName(name);
        if(0 < price)
            outfit.setPrice(price);
        if(0 < count)
            outfit.setCount(count);
        if(0 < size.length() && size != null && !Objects.equals(outfit.getSize(),size))
            outfit.setSize(size);
    }
}