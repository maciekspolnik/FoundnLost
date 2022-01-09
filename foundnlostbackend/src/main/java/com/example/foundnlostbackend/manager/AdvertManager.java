package com.example.foundnlostbackend.manager;

import com.example.foundnlostbackend.model.Advert;
import com.example.foundnlostbackend.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdvertManager {

    private AdvertRepository advertRepository;

    @Autowired
    public AdvertManager(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }


    public Iterable<Advert> findAll() {
        return advertRepository.findAll();
    }

    public Optional<Advert> findByType(String postType) {
        return advertRepository.findByPostType(postType);
    }

    public Advert add(Advert advert) {
        return advertRepository.save(advert);
    }

    public void delete(Long index) {
        advertRepository.deleteById(index);
    }
}
