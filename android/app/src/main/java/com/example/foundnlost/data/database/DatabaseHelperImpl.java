package com.example.foundnlost.data.database;

import android.content.Context;

import com.example.foundnlost.data.database.dao.UserDao;
import com.example.foundnlost.data.database.entity.UserEntity;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;


public class DatabaseHelperImpl implements DatabaseHelper {
    private final UserDao userDao;

    public DatabaseHelperImpl(Context context) {
        this.userDao = AppDatabase.getInstance(context).userDao();
    }

    @Override
    public Maybe<UserEntity> findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public Completable insertUser(UserEntity userEntity) {
        return Completable.fromAction(() -> userDao.insertUser(userEntity));
    }

    @Override
    public Completable updateUser(UserEntity userEntity) {
        return Completable.fromAction(() -> userDao.updateUser(userEntity));
    }

    @Override
    public Completable deleteUser(UserEntity userEntity) {
        return Completable.fromAction(() -> userDao.deleteUser(userEntity));

    }

    public @NonNull Completable clearDatabase() {
        return Completable.fromAction(userDao::deleteAllUsers);
    }
}
