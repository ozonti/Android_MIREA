package com.example.mirea;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.mirea.R;
import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {


    public ListFragment() {
        super(R.layout.fragment_list);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        ListView listView = view.findViewById(R.id.listView);
        List<Item> listItems = new ArrayList<>();
        for(int i = 0; i < 100; i ++){
            listItems.add(new Item(R.drawable.plus, String.valueOf(i+1)));
        }
        ListAdapter adapter = new ListAdapter(getContext(), R.layout.list_item, listItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getContext(), "ITEM " + (position + 1), Toast.LENGTH_LONG).show();
                Log.i("ListView", "Item" + (position + 1));
            }
        });

        view.findViewById(R.id.returnFromList).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.from_list_to_start);
            }
        });

        assert getArguments() != null;
        String result = getArguments().getString("listKey");
        Toast.makeText(getContext(), result, Toast.LENGTH_LONG).show();
        return view;
    }
}