package com.example.foundnlostbackend.controller;

import com.example.foundnlostbackend.Const;
import com.example.foundnlostbackend.data.ContactData;
import com.example.foundnlostbackend.data.Response;
import com.example.foundnlostbackend.manager.AdvertManager;
import com.example.foundnlostbackend.manager.UsersManager;
import com.example.foundnlostbackend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.example.foundnlostbackend.Const.RESPONSE_ERROR;

@RestController
@RequestMapping("/users/")
public class UsersController {

    @Autowired
    private UsersManager usersManager;

    @Autowired
    private AdvertManager advertManager;

    @Autowired
    public UsersController(UsersManager usersManager) {
        this.usersManager = usersManager;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Users getUsersByID(@RequestParam Long index) {
        return usersManager.findById(index);
    }

    @RequestMapping(value = "/contact_data", method = RequestMethod.GET)
    public Response<ContactData> getContactDataById(Long advertId) {
        Users user = usersManager.findById(advertManager.findByAdvertId(advertId).getUser().getUsersId());
        if (user == null) {
            return new Response<>(
                    HttpStatus.NO_CONTENT.value(),
                    "NO_DATA",
                    null);
        }

        return new Response<>(
                HttpStatus.OK.value(),
                Const.RESPONSE_SUCCESS,
                new ContactData(user.getName(), user.getSurname(), user.getPhone()));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Response<Void> addUsers(@RequestBody Users user) {
        if (usersManager.addUser(user) == null) {
            return new Response<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    RESPONSE_ERROR,
                    null);
        }
        return new Response<>(HttpStatus.OK.value(),
                Const.RESPONSE_SUCCESS,
                null);

    }

    @RequestMapping(method = RequestMethod.PUT)
    public Response<Void> alterUsers(@RequestBody Users user) {
        if (usersManager.addUser(user) == null) {
            return new Response<>(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "DATA_NOT_CHANGED",
                    null);
        }
        return new Response<>(HttpStatus.OK.value(),
                Const.RESPONSE_SUCCESS,
                null);

    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Response<Void> deleteUsers(@RequestParam Long index) {
        usersManager.deleteUser(index);
        return new Response<>(HttpStatus.OK.value(),
                Const.RESPONSE_SUCCESS,
                null);
    }

}
