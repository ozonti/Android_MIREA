package com.example.mirea;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    public static final String TAG = "My TAG";
    public FirstFragment(){
        super(R.layout.fragment_first);
    }

    @Override
    public void onAttach(@NonNull Context context){
        super.onAttach(context);
        //Toast.makeText(getContext(), "onAttach", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onAttach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*Toast.makeText(getContext(), "onCreate", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onCreate");*/



    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        /*Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_LONG).show();
        Log.i(TAG, "onCreateView");
        return super.onCreateView(inflater,container,savedInstanceState);*/

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        EditText editText = view.findViewById(R.id.edit_txt);
        Button button = view.findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                String name = editText.getText().toString();
                result.putString("bundleKey", name);
                getParentFragmentManager().setFragmentResult("Key", result);
            }
        });

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onViewCreated");
    }

    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        //Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onViewStateRestored");
    }


    //-------------------------------------------------
    @Override
    public void onStart() {
        super.onStart();
        //Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        //Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        //Toast.makeText(getContext(), "onPause", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        //Toast.makeText(getContext(), "onStop", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onStop");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        //Toast.makeText(getContext(), "onSavedInstanceState", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onSavedInstanceState");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_LONG).show();
        //Log.i(TAG, "onDestroy");
    }
}