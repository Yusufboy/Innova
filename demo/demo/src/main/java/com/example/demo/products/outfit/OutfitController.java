package com.example.demo.products.outfit;

import com.example.demo.products.outfit.Outfit;
import com.example.demo.products.outfit.OutfitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OutfitController {
    private final OutfitService outfitService;

    @Autowired
    public OutfitController(OutfitService outfitService) {
        this.outfitService = outfitService;
    }

    @GetMapping(value = "/getOutfits")
    public List<Outfit> getOutfits(){
        return outfitService.getOutfits();
    }

    @PostMapping(value = "/addOutfit")
    public void addOutfit(@RequestBody Outfit outfit){outfitService.addOutfit(outfit);}

    @DeleteMapping(path="{outfitId}")    public void deleteOutfit(@PathVariable("outfitId") Long id){outfitService.deleteOutfit(id);}

    @PutMapping(path="{outfitId}")
    public void updateOutfit(
            @PathVariable("outfitId") Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) double price,
            @RequestParam(required = false) int count,
            @RequestParam(required = false) String size){outfitService.updateOutfit(id,name,price,count,size);}
}
