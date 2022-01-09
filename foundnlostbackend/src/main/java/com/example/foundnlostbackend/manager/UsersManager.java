package com.example.foundnlostbackend.manager;

import com.example.foundnlostbackend.model.Users;
import com.example.foundnlostbackend.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersManager {

    private UsersRepository usersRepository;

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

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB(){
//        addUser(new Users("j","ho","esfdsf","5555", LocalDate.of(1999,1,1)));
//        addUser(new Users("z","zzzho","esfdsf@@","55ddd55", LocalDate.of(2079,12,11)));
//    }

}
