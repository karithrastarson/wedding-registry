package com.karithrastarson.registry.service;

import com.karithrastarson.registry.entity.Gift;
import com.karithrastarson.registry.exception.NoGiftFoundException;
import com.karithrastarson.registry.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GiftService {
    @Autowired
    GiftRepository giftRepository;

    public List<Gift> getAllItems() throws NoGiftFoundException {
        List<Gift> results = giftRepository.findByReserved(false);

        if (results.isEmpty()) {
            throw new NoGiftFoundException("No available gift found in registry");
        }

        return results;
    }
    public void addManyItems(String name, String url, int count) {
        for (int i = 0; i < count; i++) {
            addItem(name, url);
        }
    }

    public void addItem(String name, String url) {
        giftRepository.save(new Gift(name, url));
    }

    public void removeItem(String name, String url, int count) throws NoGiftFoundException {
        List<Gift> items = giftRepository.findByNameAndUrl(name, url);
        if (items.isEmpty()) {
            throw new NoGiftFoundException("No gift found with name " + name);
        }
        for (int i = 0; i < count; i++) {
            giftRepository.delete(items.get(i));
        }
    }

    public void reserveItem(String name, String userId) throws NoGiftFoundException {
        List<Gift> result = giftRepository.findByNameAndReserved(name, false);
        if (result.isEmpty()) {
            throw new NoGiftFoundException(name);
        }
        Gift gift = result.get(0);
        gift.setReserved(true);
        gift.setReserver(userId);
        giftRepository.save(gift);
    }

    public void unReserveItem(String name, String userId) throws NoGiftFoundException {
        List<Gift> results = giftRepository.findByNameAndReserver(name, userId);
        if (results.isEmpty()) {
            throw new NoGiftFoundException("No gift found with name " + name);
        }
        for (Gift gift : results) {
            gift.setReserver(null);
            gift.setReserved(false);
            giftRepository.save(gift);
        }
    }
}
