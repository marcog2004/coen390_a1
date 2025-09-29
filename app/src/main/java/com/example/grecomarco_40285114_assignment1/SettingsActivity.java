package com.example.grecomarco_40285114_assignment1;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class SettingsActivity extends AppCompatActivity {

    protected SharedPreferenceHelper sharedPreferenceHelper;

    protected Button saveButton = null;

    EditText counter1NameEditText;
    EditText counter2NameEditText;
    EditText counter3NameEditText;
    EditText maximumCountsEditText;

    private TextView maxCountsTextView;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        sharedPreferenceHelper = new SharedPreferenceHelper(SettingsActivity.this);

        counter1NameEditText = (EditText) findViewById(R.id.counter1NameEditText);
        counter2NameEditText = (EditText) findViewById(R.id.counter2NameEditText);
        counter3NameEditText = (EditText) findViewById(R.id.counter3NameEditText);
        maximumCountsEditText = (EditText) findViewById(R.id.maximumCountsEditText);

        saveButton = (Button) findViewById(R.id.saveButton) ;

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Settings Activity");

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((      String.valueOf(counter1NameEditText.getText()).length() <= 20
                        && String.valueOf(counter2NameEditText.getText()).length() <= 20
                        && String.valueOf(counter3NameEditText.getText()).length() <= 20
                        && !String.valueOf(counter1NameEditText.getText()).isEmpty()
                        && !String.valueOf(counter2NameEditText.getText()).isEmpty()
                        && !String.valueOf(counter3NameEditText.getText()).isEmpty()
                        && !String.valueOf(maximumCountsEditText.getText()).isEmpty()
                        && Integer.parseInt(String.valueOf(maximumCountsEditText.getText())) >= 5
                        && Integer.parseInt(String.valueOf(maximumCountsEditText.getText())) <= 20)) {
                    sharedPreferenceHelper.saveButtonName(1, String.valueOf(counter1NameEditText.getText()));
                    sharedPreferenceHelper.saveButtonName(2, String.valueOf(counter2NameEditText.getText()));
                    sharedPreferenceHelper.saveButtonName(3, String.valueOf(counter3NameEditText.getText()));
                    sharedPreferenceHelper.saveMaxCount(String.valueOf(maximumCountsEditText.getText()));
                    counter1NameEditText.setEnabled(false);
                    counter2NameEditText.setEnabled(false);
                    counter3NameEditText.setEnabled(false);
                    maximumCountsEditText.setEnabled(false);
                }else{
                    Toast.makeText(getApplicationContext(), "Invalid Input", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void onStart()
    {
        super.onStart();

        counter1NameEditText.setText(sharedPreferenceHelper.getButtonName((1)));
        counter2NameEditText.setText(sharedPreferenceHelper.getButtonName((2)));
        counter3NameEditText.setText(sharedPreferenceHelper.getButtonName((3)));
        maximumCountsEditText.setText(sharedPreferenceHelper.getMaxCount());

        if (String.valueOf(counter1NameEditText.getText()).isEmpty() || String.valueOf(counter2NameEditText.getText()).isEmpty() || String.valueOf(counter3NameEditText.getText()).isEmpty() || String.valueOf(maximumCountsEditText.getText()).isEmpty()) {
            counter1NameEditText.setEnabled(true);
            counter2NameEditText.setEnabled(true);
            counter3NameEditText.setEnabled(true);
            maximumCountsEditText.setEnabled(true);
        }else{
            counter1NameEditText.setEnabled(false);
            counter2NameEditText.setEnabled(false);
            counter3NameEditText.setEnabled(false);
            maximumCountsEditText.setEnabled(false);
        }

    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {// User chooses the "Settings" item. Show the app settings UI.
            counter1NameEditText.setEnabled(true);
            counter2NameEditText.setEnabled(true);
            counter3NameEditText.setEnabled(true);
            maximumCountsEditText.setEnabled((true));
            return true;
        }// The user's action isn't recognized.
        // Invoke the superclass to handle it.
        return super.onOptionsItemSelected(item);
    }

}