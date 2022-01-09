package com.example.foundnlostbackend.repository;

import com.example.foundnlostbackend.model.Advert;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AdvertRepository extends CrudRepository<Advert, Long> {

    public Optional<Advert> findByPostType(String postType);

}
