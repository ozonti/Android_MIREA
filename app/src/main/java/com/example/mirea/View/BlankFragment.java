package com.example.mirea.View;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mirea.Data.DataSources.Room.Entities.Category;
import com.example.mirea.Data.Model.FragmentNavigateData;
import com.example.mirea.R;
import com.example.mirea.ViewModel.ItemViewModel;

import java.util.HashMap;
import java.util.Map;

public class BlankFragment extends Fragment {
    private ItemViewModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container, false);
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 200; i++) {
            String text = "Hello" + (i + 1);
            map.put(text, R.drawable.minus);
        }

        viewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(requireActivity().getApplication()))
                .get(ItemViewModel.class);

        viewModel.createList(requireContext(), map);

        String itemName = getArguments().getString("itemId");

        viewModel.getLiveData().observe(getViewLifecycleOwner(), item -> {
            if (item != null) {
                TextView itemN = view.findViewById(R.id.text_view11);
                ImageView itemDescription = view.findViewById(R.id.image_view11);
                Category list = item.getCategory(itemName);
                itemN.setText(list.compName);
                itemDescription.setImageResource(list.img);
            }
        });

        return view;
    }
}