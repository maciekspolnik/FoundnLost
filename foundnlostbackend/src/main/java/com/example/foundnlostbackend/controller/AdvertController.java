package com.example.foundnlostbackend.controller;

import com.example.foundnlostbackend.manager.AdvertManager;
import com.example.foundnlostbackend.model.Advert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/advert/")
public class AdvertController {

    private AdvertManager advertManager;

    @Autowired
    public AdvertController(AdvertManager advertManager) {
        this.advertManager = advertManager;
    }

    @GetMapping("/all")
    public Iterable<Advert> getAdverts() {
        return advertManager.findAll();
    }

    @GetMapping
    public Optional<Advert> getAdvertByType(@RequestParam String type) {
        return advertManager.findByType(type);
    }

    @PostMapping
    public Advert addAdvert(@RequestBody Advert advert) {
        return advertManager.add(advert);
    }

    @PutMapping
    public Advert alterAdvert(@RequestBody Advert advert) {
        return advertManager.add(advert);
    }

    @DeleteMapping
    public void deleteAdvert(@RequestParam Long index) {
        advertManager.delete(index);
    }
}
