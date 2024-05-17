package com.example.mirea.Data.DataSources;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mirea.Data.Model.Item;
import com.example.mirea.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalDataSource implements DataSource{
    private List<Item> items = new ArrayList<>();
    LocalDataSource(){
        for (int i = 0; i < 200; i++) {
            items.add(new Item(R.drawable.plus, "Компания" + (i + 1)));
        }
    }
    public LiveData<List<Item>> getListItems(){
        MutableLiveData<List<Item>> liveData = new MutableLiveData<>();
        liveData.setValue(items);
        return liveData;
    }
}
