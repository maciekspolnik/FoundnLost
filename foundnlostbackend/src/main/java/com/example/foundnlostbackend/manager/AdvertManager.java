package com.example.foundnlostbackend.manager;

import com.example.foundnlostbackend.model.Advert;
import com.example.foundnlostbackend.model.Users;
import com.example.foundnlostbackend.repository.AdvertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertManager {

    private final AdvertRepository advertRepository;

    @Autowired
    public AdvertManager(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }


    public Iterable<Advert> findAll() {
        return advertRepository.findAll();
    }

    public Advert findByAdvertId(Long advertId) {
        return advertRepository.findByAdvertId(advertId);
    }

    public Iterable<Advert> findAllByUser(Users user){
        return advertRepository.findByUser(user);
    };

    public Advert findByType(String postType) {
        return advertRepository.findByPostType(postType);
    }

    public Advert add(Advert advert) {
        return advertRepository.save(advert);
    }

    public void delete(Long index) {
        advertRepository.deleteById(index);
    }


}
