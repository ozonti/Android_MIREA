package com.example.mirea.ViewModel;

import androidx.lifecycle.MutableLiveData;

import com.example.mirea.Data.Model.FragmentNavigateData;

public class FragmentNavigateViewModel {
    private MutableLiveData<FragmentNavigateData> data = new MutableLiveData<>();

    public FragmentNavigateViewModel(){
        data.setValue(new FragmentNavigateData());
    }
    public MutableLiveData<FragmentNavigateData> getData(){
        return data;
    }
}
