package com.example.recylerviewroom.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.recylerviewroom.User;

import java.util.List;

@Dao
public interface UserDao {
    @Insert
    void insertName(User user);

    @Query("select *from user")
    List<User>getListUser();






}
