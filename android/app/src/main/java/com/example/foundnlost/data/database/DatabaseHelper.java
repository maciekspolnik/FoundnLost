package com.example.foundnlost.data.database;

import com.example.foundnlost.data.database.entity.UserEntity;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;

public interface DatabaseHelper {

    Completable insertUser(UserEntity userEntity);

    Completable updateUser(UserEntity userEntity);

    Completable deleteUserById(Long index);

    Maybe<UserEntity> findById(Integer id);

}
