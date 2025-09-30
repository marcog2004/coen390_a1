package com.example.grecomarco_40285114_assignment1;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // variables
    protected SharedPreferenceHelper sharedPreferenceHelper;

    protected Button settingsButton = null;
    protected Button dataButton = null;
    protected Button eventButton1 = null;
    protected Button eventButton2 = null;
    protected Button eventButton3 = null;

    private TextView totalCountTextView;

    private int totalCount;
    private int count1;
    private int count2;
    private int count3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferenceHelper = new SharedPreferenceHelper(MainActivity.this);

        //sharedPreferenceHelper.resetAll(); // used to test with a blank shared preference helper

        // textview
        totalCountTextView = findViewById(R.id.totalCountTextView);

        // buttons
        eventButton1 = (Button) findViewById(R.id.eventButton1);
        eventButton2 = (Button) findViewById(R.id.eventButton2);
        eventButton3 = (Button) findViewById(R.id.eventButton3);
        settingsButton = (Button) findViewById(R.id.settingsButton);
        dataButton = (Button) findViewById(R.id.dataButton);

        // set text of textview
        totalCountTextView.setText("Total Count: " + sharedPreferenceHelper.getTotalCount());

        // button listeners
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
                    count1++;
                    sharedPreferenceHelper.addEvent("1");
                    totalCountTextView.setText("Total Count: " + totalCount);
                    sharedPreferenceHelper.saveTotalCount(totalCount);
                    sharedPreferenceHelper.saveCount1(String.valueOf(count1));
                }
            }
        });

        eventButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalCount < Integer.parseInt(sharedPreferenceHelper.getMaxCount())) {
                    totalCount++;
                    count2++;
                    sharedPreferenceHelper.addEvent("2");
                    totalCountTextView.setText("Total Count: " + totalCount);
                    sharedPreferenceHelper.saveTotalCount(totalCount);
                    sharedPreferenceHelper.saveCount2(String.valueOf(count2));
                }
            }
        });

        eventButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalCount < Integer.parseInt(sharedPreferenceHelper.getMaxCount())) {
                    totalCount++;
                    count3++;
                    sharedPreferenceHelper.addEvent("3");
                    totalCountTextView.setText("Total Count: " + totalCount);
                    sharedPreferenceHelper.saveTotalCount(totalCount);
                    sharedPreferenceHelper.saveCount3(String.valueOf(count3));
                }
            }
        });
    }

    protected void onStart()
    {
        super.onStart();

        // update button names when returning to activity
        if (sharedPreferenceHelper.getButtonName(1) == null | sharedPreferenceHelper.getButtonName(2) == null | sharedPreferenceHelper.getButtonName(3) == null){
            goToSettingsActivity();
        }else {

            eventButton1.setText(sharedPreferenceHelper.getButtonName(1));
            eventButton2.setText(sharedPreferenceHelper.getButtonName(2));
            eventButton3.setText(sharedPreferenceHelper.getButtonName(3));
        }

        totalCount = sharedPreferenceHelper.getTotalCount();
    }

    // settings activity intent
    void goToSettingsActivity ()
    {
        Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
        startActivity(intent);
    }

    // data activity intent
    void goToDataActivity()
    {
        Intent intent = new Intent(MainActivity.this, DataActivity.class);
        startActivity(intent);
    }

}