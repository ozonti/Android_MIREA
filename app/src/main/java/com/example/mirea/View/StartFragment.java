package com.example.mirea.View;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mirea.Data.Model.FragmentNavigateData;
import com.example.mirea.R;

public class StartFragment extends Fragment {

    public FragmentNavigateData dataLayer = new FragmentNavigateData();

    public StartFragment() {
        super(R.layout.fragment_start);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        view.findViewById(R.id.toListFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                bundle.putString("listKey", dataLayer.getDatafromFirstToList());
                Navigation.findNavController(v).navigate(R.id.from_start_to_list, bundle);
            }
        });

        view.findViewById(R.id.toRecyclerFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                String result = "Данные, переданные из StartFragment в RecyclerFragment";
                bundle.putString("recyclerKey", dataLayer.getDatafromFirstToRecycler());
                Navigation.findNavController(v).navigate(R.id.from_start_to_recycler, bundle);
            }
        });

        return view;
    }


}