package com.example.foundnlostbackend.controller;

import com.example.foundnlostbackend.Const;
import com.example.foundnlostbackend.data.ContactData;
import com.example.foundnlostbackend.data.Response;
import com.example.foundnlostbackend.manager.UsersManager;
import com.example.foundnlostbackend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/")
public class UsersController {

    @Autowired
    private UsersManager usersManager;

    @Autowired
    public UsersController(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Users getUsersByID(@RequestParam Long index) {
        return usersManager.findById(index);
    }

    @RequestMapping(value = "/contact_data", method = RequestMethod.GET)
    public Response<ContactData> getContactDataById(@RequestParam Long index) {
        Users user = usersManager.findById(index);
        if (user == null) {
            return new Response<>(
                    HttpStatus.NO_CONTENT.value(),
                    Const.RESPONSE_NO_DATA,
                    null);
        }

        return new Response<>(
                HttpStatus.OK.value(),
                Const.RESPONSE_SUCCESS,
                new ContactData(user.getEmail(), user.getPhone()));
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Response<Void> deleteUsers(@RequestParam Long index) {
        usersManager.deleteUser(index);
        return new Response<>(HttpStatus.OK.value(),
                Const.RESPONSE_SUCCESS,
                null);
    }

}
