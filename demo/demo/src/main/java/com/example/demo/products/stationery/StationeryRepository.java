package com.example.demo.products.stationery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StationeryRepository extends JpaRepository<Stationery,Long> {

    @Query("SELECT s FROM Stationery s WHERE s.name = ?1")
    Optional<Stationery> findStationeryByName(String name);
}
