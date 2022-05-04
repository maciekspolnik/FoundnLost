package com.example.foundnlostbackend.repository;

import com.example.foundnlostbackend.model.Advert;
import com.example.foundnlostbackend.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AdvertRepository extends CrudRepository<Advert, Long> {

    Iterable<Advert> findAllByPostType(String postType);

    Advert findByAdvertId(Long advertId);

    Iterable<Advert> findByUser(Users user);

    @Query("SELECT a FROM Advert a WHERE a.postType LIKE :type")
    Iterable<Advert> findAllByType(String type);

}
