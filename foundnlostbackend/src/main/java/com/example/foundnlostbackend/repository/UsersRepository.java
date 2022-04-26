package com.example.foundnlostbackend.repository;

import com.example.foundnlostbackend.model.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {

    Users findUsersByEmailAndPassword(String email, String password);

    Users findUsersByEmail(String email);

    Boolean existsByEmail(String email);
}
