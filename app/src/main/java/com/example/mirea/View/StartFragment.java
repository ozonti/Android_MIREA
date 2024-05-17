package com.example.mirea.View;

import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mirea.Data.DataSources.Repository;
import com.example.mirea.Data.Model.FragmentNavigateData;
import com.example.mirea.R;

public class StartFragment extends Fragment {

    private static final int PERMISSION_REQUEST_CODE = 80;
    public FragmentNavigateData dataLayer = new FragmentNavigateData();

    public StartFragment() {
        super(R.layout.fragment_start);
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start, container, false);

        TextView itemName = view.findViewById(R.id.textView);
        Repository repository = new Repository(this.getContext(), "file1.txt", "SDFile");
        repository.writeAppSpecDS("Какой-то текст");


        ImageView imageView = view.findViewById(R.id.imageView);
        repository.createLocalds(this.getContext());
        repository.setLocalName("ТЕСТ");
        repository.setLocalImg(R.drawable.plus);
        TextView textV = view.findViewById(R.id.textView);
        textV.setText(repository.getItems().getText());
        imageView.setImageResource(repository.getItems().getImageResource());

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


        TextView itemNameCom = view.findViewById(R.id.textCommon);
        view.findViewById(R.id.CommonFilesDSButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!repository.writeCommonFileDS("Список компаний актуален Common")) {
                    requestPermission();
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    repository.writeCommonFileDS("Список компаний актуален Common");
                }
                String result = repository.readCommonFilesDS();
                itemNameCom.setText(result);
            }
        });

        return view;
    }


    private void requestPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            Toast.makeText(getContext(), "Требуется разрешение на запись на карту памяти!", Toast.LENGTH_LONG).show();
        }
        else {
            ActivityCompat.requestPermissions(getActivity(), new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE && (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
            Log.e("value", "Разрешение есть.");
        }
    }

}