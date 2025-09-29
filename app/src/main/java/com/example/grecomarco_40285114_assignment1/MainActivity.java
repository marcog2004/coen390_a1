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
    protected Button eventButton1 = null;
    protected Button eventButton2 = null;
    protected Button eventButton3 = null;

    private TextView totalCountTextView;
    private int totalCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);

        settingsButton = (Button) findViewById(R.id.settingsButton);

        totalCountTextView = findViewById(R.id.totalCountTextView);
        totalCountTextView.setText("Total Count: " + totalCount);


        settingsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToSettingsActivity();
            }
        });


    }

    protected void onStart()
    {
        super.onStart();

        eventButton1 = (Button) findViewById(R.id.eventButton1);
        eventButton2 = (Button) findViewById(R.id.eventButton2);
        eventButton3 = (Button) findViewById(R.id.eventButton3);

        eventButton1.setText(sharedPreferenceHelper.getButtonName(1));
        eventButton2.setText(sharedPreferenceHelper.getButtonName(2));
        eventButton3.setText(sharedPreferenceHelper.getButtonName(3));

    }

    void goToSettingsActivity ()
    {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }


}