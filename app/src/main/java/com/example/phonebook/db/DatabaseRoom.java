package com.example.phonebook.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.phonebook.db.dao.UserDao;
import com.example.phonebook.db.entity.User;

@Database(entities = {User.class},version = 1,exportSchema = false)
public abstract class DatabaseRoom extends RoomDatabase {

    public abstract UserDao userDao();

    public static DatabaseRoom getInstance(Context context){
        return Room.databaseBuilder(context, DatabaseRoom.class,"DB_NAME").allowMainThreadQueries().build();
    }
}
