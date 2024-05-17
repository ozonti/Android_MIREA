package com.example.mirea.Data.DataSources.Room.Entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "Comp")
    public String compName;
    @ColumnInfo(name = "img")
    public int img;
}
