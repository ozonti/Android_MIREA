package com.example.mirea.Data.DataSources.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.example.mirea.Data.DataSources.Room.DAO.ListDAO;
import com.example.mirea.Data.DataSources.Room.Entities.Category;
@Database(entities = {Category.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "List";
    public abstract ListDAO listDAO();
}