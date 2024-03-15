package com.example.mirea;

import static com.example.mirea.MainActivity.KEY;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Objects;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getAll();
    }


    private void getAll(){
        Bundle arg = getIntent().getExtras();
        assert arg != null;
        String name = Objects.requireNonNull(arg.get("key")).toString();

        Log.i(MainActivity.TAG, name);
    }


    public  void  onClick1(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY, "GoodBye World!");
        setResult(RESULT_OK, intent);
        finish();
    }
}