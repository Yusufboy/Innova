package com.example.demo.products.outfit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit,Long> {

    @Query("SELECT s FROM Outfit s WHERE s.name = ?1")
    Optional<Outfit> findOutfitByName(String name);

    @Query("SELECT s FROM Outfit s WHERE s.size = ?1")
    Optional<Outfit> findOutfitBySize(String size);
}