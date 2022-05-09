package com.example.foundnlostbackend.repository;

import com.example.foundnlostbackend.model.Advert;
import com.example.foundnlostbackend.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface AdvertRepository extends CrudRepository<Advert, Long> {

    Advert findByAdvertId(Long advertId);

    Iterable<Advert> findByUser(Users user);

}
