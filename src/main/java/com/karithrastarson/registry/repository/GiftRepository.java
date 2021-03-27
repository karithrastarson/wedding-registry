package com.karithrastarson.registry.repository;

import com.karithrastarson.registry.entity.Gift;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GiftRepository extends CrudRepository<Gift, Long> {
    List<Gift> findByNameAndReserved(String name, boolean reserved);

    List<Gift> findByReserved(boolean reserved);

    List<Gift> findByNameAndReserver(String name, String reserver);

    List<Gift> findByNameAndUrl(String name, String url);

    @Query(value="SELECT name, COUNT(name) FROM gift GROUP BY name", nativeQuery = true)
    List<Gift> getItemCount();
}
