package com.example.foundnlostbackend.controler;

import com.example.foundnlostbackend.manager.UsersManager;
import com.example.foundnlostbackend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users/")
public class UsersController {

    private UsersManager usersManager;

    @Autowired
    public UsersController(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @GetMapping("/all")
    public Iterable<Users> getUsers(){
        return usersManager.findAll();
    }

    @GetMapping
    public Optional<Users> getUsers(@RequestParam Long index){
        return usersManager.findById(index);
    }

    @PostMapping
    public Users addUsers(@RequestBody Users users){
        return usersManager.addUser(users);
    }

    @PutMapping
    public Users alterUsers(@RequestBody Users users){
        return usersManager.addUser(users);
    }

    @DeleteMapping
    public void deleteUsers(@RequestParam Long index){
       usersManager.deleteUser(index);
    }

}
