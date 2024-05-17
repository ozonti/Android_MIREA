package com.example.mirea.Data.DataSources.Room.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mirea.Data.DataSources.Room.Entities.Category;

import java.util.ArrayList;
import java.util.List;
@Dao
public interface ListDAO {
    //@Query("SELECT * FROM Category")
    //List<Category> getAll();
    @Query("SELECT * FROM Category WHERE Comp LIKE :itemName")
    Category getCategoryByName(String itemName);
    //void insertAll(ArrayList<Category> categories);
    @Insert
    void insertCategory(Category... categories);
    @Delete
    void deleteCategory(Category category);
    @Update
    void updateCategory(Category category);
}