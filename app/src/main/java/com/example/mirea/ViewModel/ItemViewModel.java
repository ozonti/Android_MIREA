package com.example.mirea.ViewModel;
import android.content.Context;

import com.example.mirea.Data.DataSources.Repository;
import com.example.mirea.R;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.example.mirea.Data.Model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import androidx.lifecycle.ViewModel;

public class ItemViewModel  extends ViewModel {


    private Repository repository = new Repository();
    private final MutableLiveData<Repository> liveData = new MutableLiveData<>(new Repository());
    public LiveData<List<Item>> getListItems() {
        return repository.getListItems();
    }
    public void createList(Context context, Map<String, Integer> categories) {
        Objects.requireNonNull(liveData.getValue()).createDatabase(context, categories);
    }
    public LiveData<Repository> getLiveData() {
        return liveData;
    }


    /*private MutableLiveData<List<Item>> listItems = new MutableLiveData<>();


    public ItemViewModel() {
        List<Item> items = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            items.add(new Item(R.drawable.plus, "Test" + (i + 1)));
        }
        listItems.setValue(items);
    }

    public LiveData<List<Item>> getListItems() {
        return listItems;
    }*/

}
