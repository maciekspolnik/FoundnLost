package com.example.foundnlostbackend.controller;

import com.example.foundnlostbackend.Const;
import com.example.foundnlostbackend.data.AddAdvert;
import com.example.foundnlostbackend.data.Response;
import com.example.foundnlostbackend.manager.AdvertManager;
import com.example.foundnlostbackend.manager.UsersManager;
import com.example.foundnlostbackend.mapper.AdvertMapper;
import com.example.foundnlostbackend.model.Advert;
import com.example.foundnlostbackend.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/advert/")
public class AdvertController {

    @Autowired
    private final AdvertManager advertManager;

    @Autowired
    private final UsersManager usersManager;

    @Autowired
    public AdvertController(AdvertManager advertManager, UsersManager usersManager) {
        this.advertManager = advertManager;
        this.usersManager = usersManager;
    }

    @RequestMapping(value = "/find_by_id", method = RequestMethod.GET)
    public Response<Iterable<Advert>> getAdvertByUserId(@RequestParam Long index) {
        Users user = usersManager.findById(index);
        if (user == null) {
            return new Response<>(HttpStatus.NO_CONTENT.value(), Const.RESPONSE_NO_DATA, null);
        }
        Iterable<Advert> adverts = advertManager.findAllByUser(user);
        if (adverts == null) {
            return new Response<>(HttpStatus.NO_CONTENT.value(), Const.RESPONSE_NO_DATA, null);
        }
        return new Response<>(HttpStatus.OK.value(), Const.RESPONSE_SUCCESS, adverts);
    }

    @RequestMapping(value = "/find_by_type", method = RequestMethod.GET)
    public Response<Advert> getAdvertByType(@RequestParam String type) {
        Iterable<Advert> advert = advertManager.findByType(type);
        if (advert == null) {
            return new Response<>(HttpStatus.NO_CONTENT.value(), Const.RESPONSE_NO_DATA, null);
        }
        return new Response<>(HttpStatus.OK.value(), Const.RESPONSE_SUCCESS, advert);
    }

    @PostMapping
    public Response<Advert> addAdvert(@RequestBody AddAdvert addAdvert) {
        Users user = usersManager.findById(addAdvert.getUserId());
        if (user == null) {
            return new Response<>(HttpStatus.NO_CONTENT.value(), Const.RESPONSE_NO_DATA, null);

        }
        Advert advert = advertManager.add(AdvertMapper.mapToAdvert(addAdvert, user));
        if (advert == null) {
            return new Response<>(HttpStatus.NO_CONTENT.value(), Const.RESPONSE_NO_DATA, null);

        }
        return new Response<>(HttpStatus.OK.value(), Const.RESPONSE_SUCCESS, advert);
    }

    @DeleteMapping
    public Response<Void> deleteAdvert(@RequestParam Long index) {
        advertManager.delete(index);
        return new Response<>(HttpStatus.OK.value(), Const.RESPONSE_SUCCESS, null);
    }
}
