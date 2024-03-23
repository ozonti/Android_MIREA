package com.example.mirea;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public MainActivity(){
        super(R.layout.activity_main);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.first_fragment, FirstFragment.class, null)
                    .add(R.id.first_fragment, SecondFragment.class, null)
                    .add(R.id.first_fragment, ThirdFragment.class, null)
                    //.add(R.id.first_fragment, FourthFragment.class, null)
                    .commit();
        }
    }
}