package com.karithrastarson.registry.controller;

import com.karithrastarson.registry.entity.Gift;
import com.karithrastarson.registry.exception.NoGiftFoundException;
import com.karithrastarson.registry.service.GiftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/register")
public class GiftController {

    @Autowired
    GiftService giftService;

    /**
     * Endpoint: Post a new gift to the registry
     *
     * @return Confirmation message
     */
    @PostMapping(path = "")
    public @ResponseBody
    ResponseEntity<String> addGift(@RequestBody GiftItem item) {
        giftService.addManyItems(item.getName(), item.getUrl(), item.getCount());
        return new ResponseEntity<>("Gift added to database", HttpStatus.CREATED);
    }

    /**
     * Endpoint: Reserve a gift in registry
     *
     * @return Confirmation message
     */
    @PostMapping(path = "/{userId}")
    public @ResponseBody
    ResponseEntity<String> reserveGift(@RequestBody GiftItem item, @PathVariable("userId") String userId) {
        try {
            giftService.reserveItem(item.getName(), userId);
        } catch (NoGiftFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Gift reserved", HttpStatus.OK);
    }

    /**
     * Endpoint: Remove reservation
     *
     * @return Confirmation message
     */
    @DeleteMapping(path = "/{userId}")
    public @ResponseBody
    ResponseEntity<String> unReserveGift(@RequestBody GiftItem item, @PathVariable("userId") String userId) {
        giftService.unReserveItem(item.getName(), userId);
        return new ResponseEntity<>("Reservation removed", HttpStatus.ACCEPTED);
    }


    /**
     * Get all items in registry
     * @return all items in registry
     */
    @GetMapping(path = "")
    public @ResponseBody
    ResponseEntity<List<Gift>> getRegistry() {
        List<Gift> items = giftService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    /**
     * Endpoint: Delete an item from registry
     *
     * @return Confirmation message
     */
    @DeleteMapping(path = "")
    public @ResponseBody
    ResponseEntity<String> deleteItem(@RequestBody GiftItem item) {
        giftService.removeItem(item.getName(), item.getUrl(), item.getCount());
        return new ResponseEntity<>("Gift removed from database", HttpStatus.ACCEPTED);
    }

    static class GiftItem {
        private String name;
        private String url;
        private int count;

        public GiftItem() {

        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }

        public int getCount() {
            return count;
        }
    }

}
