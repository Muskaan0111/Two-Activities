package com.example.twoactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.twoactivity.databinding.ActivityMainBinding;
import com.example.twoactivity.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
    private static final String LOG_TAG = SecondActivity.class.getSimpleName();
    public static final String EXTRA_REPLY =
            "com.example.android.twoactivities.extra.REPLY";
    ActivitySecondBinding c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        c = ActivitySecondBinding.inflate(getLayoutInflater());

        setContentView(c.getRoot());




        // Getting the intent
        Intent intent=getIntent();

        // Extracting the string
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);
        textView.setText(message);







    }

    public void returnReply(View view) {
        //Getting the reply

        String reply = c.editTextSecond.getText().toString();
        // Creating a reply intent
        Intent replyIntent = new Intent();
        //Sending the intent
        replyIntent.putExtra(EXTRA_REPLY, reply);
        setResult(RESULT_OK,replyIntent);


        //Finishing the activity
        finish();


    }
}