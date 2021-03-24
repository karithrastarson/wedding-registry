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

    public List<Gift> getAllItems() {
        Iterable<Gift> results = giftRepository.findAll();

        List<Gift> list = new ArrayList<Gift>();
        results.forEach(list::add);

        return list;
    }
    public void addManyItems(String name, String url, int count) {
        for (int i = 0; i < count; i++) {
            addItem(name, url);
        }
    }

    public void addItem(String name, String url) {
        giftRepository.save(new Gift(name, url));
    }

    public void removeItem(String name, String url, int count) {
        List<Gift> items = giftRepository.findByNameAndUrl(name, url);
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

    public void unReserveItem(String name, String userId) {
        List<Gift> results = giftRepository.findByNameAndReserver(name, userId);
        if (results.isEmpty()) {
            return;
        }
        for (Gift gift : results) {
            gift.setReserver(null);
            gift.setReserved(false);
            giftRepository.save(gift);
        }
    }
}
