package com.example.mirea.Data.DataSources;

import androidx.lifecycle.LiveData;

import com.example.mirea.Data.Model.Item;

import java.util.List;

public interface DataSource {
    LiveData<List<Item>> getListItems();
}
