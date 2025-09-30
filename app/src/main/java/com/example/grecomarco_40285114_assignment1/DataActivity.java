package com.example.grecomarco_40285114_assignment1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DataActivity extends AppCompatActivity {

// variables
    protected SharedPreferenceHelper sharedPreferenceHelper;

    private TextView counter1TextView;
    private TextView counter2TextView;
    private TextView counter3TextView;
    private TextView totalCounterTextView;

    boolean eventNames = true;

    String counter1TextViewString;
    String counter2TextViewString;
    String counter3TextViewString;
    String totalCounterTextViewString;

    String count1String;
    String count2String;
    String count3String;
    Toolbar toolbar2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        sharedPreferenceHelper = new SharedPreferenceHelper(DataActivity.this);

        counter1TextView = findViewById(R.id.counter1TextView);
        counter2TextView = findViewById(R.id.counter2TextView);
        counter3TextView = findViewById(R.id.counter3TextView);
        totalCounterTextView = findViewById(R.id.totalCounterTextView);

        // set up toolbar
        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar2);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Data Activity");
    }

    @Override
    protected void  onStart(){
        super.onStart();

        // set names when returning to activity
        eventNames = true;
        setNames();

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.data_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_toggle) {// User chooses the "Toggle" item. Show the app settings UI.
            eventNames = !eventNames;
            setNames();
            return true;
        }// The user's action isn't recognized.
        // Invoke the superclass to handle it.
        return super.onOptionsItemSelected(item);
    }

    public void setNames(){

        // change between event names and counter numbers when pressing button

        if (sharedPreferenceHelper.getCount1() == null) {count1String = "0";}else {count1String = String.valueOf(sharedPreferenceHelper.getCount1());}
        if (sharedPreferenceHelper.getCount2() == null) {count2String = "0";}else {count2String = String.valueOf(sharedPreferenceHelper.getCount2());}
        if (sharedPreferenceHelper.getCount3() == null) {count3String = "0";}else {count3String = String.valueOf(sharedPreferenceHelper.getCount3());}

        if (eventNames) {
            counter1TextViewString = sharedPreferenceHelper.getButtonName(1) + ": " + count1String + " events";
            counter1TextView.setText(counter1TextViewString);
            counter2TextViewString = sharedPreferenceHelper.getButtonName(2) + ": " + count2String + " events";
            counter2TextView.setText(counter2TextViewString);
            counter3TextViewString = sharedPreferenceHelper.getButtonName(3) + ": " + count3String + " events";
            counter3TextView.setText(counter3TextViewString);
        }else {
            counter1TextViewString = "Counter 1: " + count1String + " events";
            counter1TextView.setText(counter1TextViewString);
            counter2TextViewString = "Counter 2: " + count2String + " events";
            counter2TextView.setText(counter2TextViewString);
            counter3TextViewString = "Counter 3: " + count3String + " events";
            counter3TextView.setText(counter3TextViewString);
        }

        totalCounterTextViewString = "Total events: " + String.valueOf(sharedPreferenceHelper.getTotalCount());
        totalCounterTextView.setText(totalCounterTextViewString);
    }
}


