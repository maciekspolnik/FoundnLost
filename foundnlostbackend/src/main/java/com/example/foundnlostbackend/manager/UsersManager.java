package com.example.foundnlostbackend.manager;

import com.example.foundnlostbackend.model.Users;
import com.example.foundnlostbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service(value = "usersManager")
public class UsersManager {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    public UsersManager(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<Users> findById(Long index) {
        return usersRepository.findById(index);
    }

    public Iterable<Users> findAll() {
        return usersRepository.findAll();
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

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        addUser(new Users("j", "ho", "esfdsf", "m1111111", "5555", LocalDate.of(1999, 1, 1)));
        addUser(new Users("z", "zzzho", "esfdsf@@", "m2394", "55ddd55", LocalDate.of(2079, 12, 11)));
    }

}
