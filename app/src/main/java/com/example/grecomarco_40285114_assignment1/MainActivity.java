package com.example.grecomarco_40285114_assignment1;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    protected SharedPreferenceHelper sharedPreferenceHelper;

    protected Button settingsButton = null;
    protected Button dataButton = null;
    protected Button eventButton1 = null;
    protected Button eventButton2 = null;
    protected Button eventButton3 = null;

    private TextView totalCountTextView;
    private int totalCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);

        sharedPreferenceHelper.resetAll();

        settingsButton = (Button) findViewById(R.id.settingsButton);
        dataButton = (Button) findViewById(R.id.dataButton);

        totalCountTextView = findViewById(R.id.totalCountTextView);

        eventButton1 = (Button) findViewById(R.id.eventButton1);
        eventButton2 = (Button) findViewById(R.id.eventButton2);
        eventButton3 = (Button) findViewById(R.id.eventButton3);

        totalCountTextView.setText("Total Count: " + sharedPreferenceHelper.getTotalCount());

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettingsActivity();
            }
        });

        dataButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { goToDataActivity(); }
        });



        eventButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalCount < Integer.parseInt(sharedPreferenceHelper.getMaxCount())) {
                    totalCount++;
                    totalCountTextView.setText("Total Count: " + totalCount);
                    sharedPreferenceHelper.saveTotalCount(totalCount);
                }
            }
        });

        eventButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalCount < Integer.parseInt(sharedPreferenceHelper.getMaxCount())) {
                    totalCount++;
                    totalCountTextView.setText("Total Count: " + totalCount);
                    sharedPreferenceHelper.saveTotalCount(totalCount);
                }
            }
        });

        eventButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalCount < Integer.parseInt(sharedPreferenceHelper.getMaxCount())) {
                    totalCount++;
                    totalCountTextView.setText("Total Count: " + totalCount);
                    sharedPreferenceHelper.saveTotalCount(totalCount);
                }
            }
        });

    }

    protected void onStart()
    {
        super.onStart();

        if (sharedPreferenceHelper.getButtonName(1) == null | sharedPreferenceHelper.getButtonName(2) == null | sharedPreferenceHelper.getButtonName(3) == null){
            goToSettingsActivity();
        }else {

            eventButton1.setText(sharedPreferenceHelper.getButtonName(1));
            eventButton2.setText(sharedPreferenceHelper.getButtonName(2));
            eventButton3.setText(sharedPreferenceHelper.getButtonName(3));
        }

        totalCount = sharedPreferenceHelper.getTotalCount();

    }

    void goToSettingsActivity ()
    {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    void goToDataActivity()
    {
        Intent intent = new Intent(MainActivity.this, DataActivity.class);
        startActivity(intent);
    }

}