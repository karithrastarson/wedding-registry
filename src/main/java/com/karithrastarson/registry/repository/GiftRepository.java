package com.karithrastarson.registry.repository;

import com.karithrastarson.registry.entity.Gift;
import org.springframework.data.repository.CrudRepository;


public interface GiftRepository extends CrudRepository<Gift, Long> {

}
