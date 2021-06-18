package com.example.managementemployee.employeeadapter.data;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.managementemployee.employeeadapter.Employeesdao;
import com.example.managementemployee.employeeadapter.entity.Employees;

@Database(entities = {Employees.class},version = 1)
public abstract class DatabaseHelper extends RoomDatabase {
    private static DatabaseHelper appDatabase;
    public abstract Employeesdao employeeDao();

    public static DatabaseHelper getAppDatabase(Context context){
        if (appDatabase == null){
            appDatabase = Room.databaseBuilder(context,
                    DatabaseHelper.class,"News").allowMainThreadQueries().build();
        }
        return appDatabase;
    }
}
