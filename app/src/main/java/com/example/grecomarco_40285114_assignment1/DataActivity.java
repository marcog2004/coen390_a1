package com.example.grecomarco_40285114_assignment1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

    private android.widget.ArrayAdapter<String> eventAdapter;

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

        android.widget.ListView eventListView = findViewById(R.id.eventListView);
        eventAdapter = new android.widget.ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new java.util.ArrayList<>());
        eventListView.setAdapter(eventAdapter);
    }

    @Override
    protected void  onStart(){
        super.onStart();

        // set names when returning to activity
        eventNames = true;
        setNames();
    }

    // toolbar setup (from linked resource in assignment doc)
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
        if (item.getItemId() == R.id.action_toggle) {// user clicks toggle names
            eventNames = !eventNames;
            setNames();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setNames(){

        // change between event names and counter numbers when pressing button

        // ensure 0 is printed as "0" and not "null"
        if (sharedPreferenceHelper.getCount1() == null) {count1String = "0";}else {count1String = String.valueOf(sharedPreferenceHelper.getCount1());}
        if (sharedPreferenceHelper.getCount2() == null) {count2String = "0";}else {count2String = String.valueOf(sharedPreferenceHelper.getCount2());}
        if (sharedPreferenceHelper.getCount3() == null) {count3String = "0";}else {count3String = String.valueOf(sharedPreferenceHelper.getCount3());}

        if (eventNames) {
            // show totals using event names
            counter1TextViewString = sharedPreferenceHelper.getButtonName(1) + ": " + count1String + " events";
            counter1TextView.setText(counter1TextViewString);
            counter2TextViewString = sharedPreferenceHelper.getButtonName(2) + ": " + count2String + " events";
            counter2TextView.setText(counter2TextViewString);
            counter3TextViewString = sharedPreferenceHelper.getButtonName(3) + ": " + count3String + " events";
            counter3TextView.setText(counter3TextViewString);

            // create the list using event names
            java.util.List<String> events = sharedPreferenceHelper.getEventList();
            java.util.List<String> displayEvents = new java.util.ArrayList<>();

            for (String e : events) {
                switch (e) {
                    case "1":
                        displayEvents.add(sharedPreferenceHelper.getButtonName(1));
                        break;
                    case "2":
                        displayEvents.add(sharedPreferenceHelper.getButtonName(2));
                        break;
                    case "3":
                        displayEvents.add(sharedPreferenceHelper.getButtonName(3));
                        break;
                    default:
                        displayEvents.add("error");
                }
            }

            // update list
            eventAdapter.clear();
            eventAdapter.addAll(displayEvents);
            eventAdapter.notifyDataSetChanged();

        }else {

            // show totals using event numbers
            counter1TextViewString = "Counter 1: " + count1String + " events";
            counter1TextView.setText(counter1TextViewString);
            counter2TextViewString = "Counter 2: " + count2String + " events";
            counter2TextView.setText(counter2TextViewString);
            counter3TextViewString = "Counter 3: " + count3String + " events";
            counter3TextView.setText(counter3TextViewString);

            // create list using event numbers
            java.util.List<String> events = sharedPreferenceHelper.getEventList();

            // update list
            eventAdapter.clear();
            eventAdapter.addAll(events);
            eventAdapter.notifyDataSetChanged();
        }

        // update total event count
        totalCounterTextViewString = "Total events: " + String.valueOf(sharedPreferenceHelper.getTotalCount());
        totalCounterTextView.setText(totalCounterTextViewString);
    }
}