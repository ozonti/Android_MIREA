package com.example.mirea.Data.DataSources;

import androidx.lifecycle.LiveData;

import com.example.mirea.Data.Model.Item;

import java.util.List;

public class Repository {

    private LocalDataSource dataSource = new LocalDataSource();

    public LiveData<List<Item>> getListItems(){
        return dataSource.getListItems();
    }
}
