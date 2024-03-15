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

    public static final String TAG = "MyTag";
    public static final String KEY = "key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "Вывелось удачно!");
            }
        });*/
    }
    public  void  onClick(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(KEY, "Hello World!");
        mStartForResult.launch(intent);
    }
    public void logClick(View view){
        Log.i(TAG, "Вывелось удачно!");
    }


    ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            if (o.getResultCode() == AppCompatActivity.RESULT_OK){
                Intent data = o.getData();
                String returned = data.getStringExtra("key");
                Log.i(TAG, returned);
            }
        }
    });
}