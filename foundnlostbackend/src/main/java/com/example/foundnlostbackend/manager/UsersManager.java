package com.example.foundnlostbackend.manager;

import com.example.foundnlostbackend.model.Users;
import com.example.foundnlostbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersManager {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersManager(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users findById(Long index) {
        return usersRepository.findUsersByUsersId(index);
    }

    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    public Users findByEmailAndPassword(String email, String password) {
        return usersRepository.findUsersByEmailAndPassword(email, password);
    }

    public Boolean isEmailAvailable(String email) {
        return usersRepository.existsByEmail(email);
    }

    public Users findByEmail(String email) {
        return usersRepository.findUsersByEmail(email);
    }

}
