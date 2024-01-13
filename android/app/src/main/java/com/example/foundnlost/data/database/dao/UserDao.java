package com.example.foundnlost.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foundnlost.data.database.entity.UserEntity;

import io.reactivex.rxjava3.core.Maybe;

@Dao
public interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertUser(UserEntity userEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void updateUser(UserEntity userEntity);

    @Delete
    void deleteUser(UserEntity user);

    @Query("SELECT * FROM users WHERE user_id = :id")
    Maybe<UserEntity> findById(Integer id);

    @Query("SELECT * FROM users WHERE name LIKE :name AND surname LIKE :surname LIMIT 1")
    Maybe<UserEntity> findByName(String name, String surname);

    @Query("DELETE FROM users")
    void deleteAllUsers();

}