package com.example.twoactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.twoactivity.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =MainActivity.class.getSimpleName() ;
    public static final String EXTRA_MESSAGE =
            "com.example.android.twoactivity.extra.MESSAGE";

    public static final int TEXT_REQUEST = 1;

        ActivityMainBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(b.getRoot());





    }

    public void launchSecondActivity(View view) {
        Toast.makeText(this, "Button CLicked!!", Toast.LENGTH_SHORT).show();

        // Creating a new Intent
        Intent intent =new Intent(this,SecondActivity.class);


        // Getting the string input to the intent


        String message = b.editTextMain.getText().toString();

        // Adding to intent
        intent.putExtra(EXTRA_MESSAGE,message);

        //Starting the activity
        startActivityForResult(intent,TEXT_REQUEST);






        //Log.d(LOG_TAG,"Button Clicked!");
        



    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST){
            if(resultCode==RESULT_OK) {


                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);

                b.textHeaderReply.setVisibility(View.VISIBLE);
                b.textMessageReply.setText(reply);
                b.textMessageReply.setVisibility(View.VISIBLE);



            }
        }
    }

}