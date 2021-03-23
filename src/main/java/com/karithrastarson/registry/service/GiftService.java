package com.karithrastarson.registry.service;

import com.karithrastarson.registry.entity.Gift;
import com.karithrastarson.registry.exception.NoGiftFoundException;
import com.karithrastarson.registry.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class GiftService {
    @Autowired
    GiftRepository giftRepository;

}
