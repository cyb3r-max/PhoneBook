package com.example.phonebook.db.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.phonebook.db.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from User")
    public List<User> users();

    @Insert
    public void insert(List<User> users);

    @Insert
    public void insert(User user);
}
