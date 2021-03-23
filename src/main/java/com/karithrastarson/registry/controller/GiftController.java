package com.karithrastarson.registry.controller;

import com.karithrastarson.registry.exception.NoGiftFoundException;
import com.karithrastarson.registry.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/register")
public class GiftController {

    @Autowired
    GiftService giftService;

}
