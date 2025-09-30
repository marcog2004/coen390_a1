package com.example.grecomarco_40285114_assignment1;
import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.text.TextUtils;


public class SharedPreferenceHelper {

    private SharedPreferences sharedPreferences;

    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE );
    }

    // reset everything
    public void resetAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();   // clears the whole file
        editor.apply();
        clearEventList();
    }

    // save button name / event name
    public void saveButtonName(int number, String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("buttonName" + number, name);
        editor.commit();
    }

    // save the total count
    public void saveTotalCount(int count) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("totalCount", count);
        editor.commit();
    }

    // save the maximum count
    public void saveMaxCount(String maxCount){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("maxCount", maxCount);
        editor.commit();
    }

    // various save functions
    public void saveCount1(String count1){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("count1", count1);
        editor.commit();
    }

    public void saveCount2(String count2){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("count2", count2);
        editor.commit();
    }

    public void saveCount3(String count3){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("count3", count3);
        editor.commit();
    }

    // return button / event names
    public String getButtonName(int number) {
        switch (number) {
            case 1:
                return sharedPreferences.getString("buttonName1", null);
            case 2:
                return sharedPreferences.getString("buttonName2", null);
            case 3:
                return sharedPreferences.getString("buttonName3", null);
            default:
                return "";
        }
    }

    // various other getters
    public int getTotalCount() {
        return sharedPreferences.getInt("totalCount", 0);
    }

    public String getMaxCount() {
        return sharedPreferences.getString("maxCount", null);
    }


    public String getCount1(){
        return sharedPreferences.getString("count1", null);
    }

    public String getCount2(){
        return sharedPreferences.getString("count2", null);
    }

    public String getCount3(){
        return sharedPreferences.getString("count3", null);
    }

    // add an event to the csv event list
    public void addEvent(String event) {
        List<String> events = getEventList();
        events.add(event);
        saveEventList(events);
    }

    // get the csv list of events
    public List<String> getEventList() {
        String csv = sharedPreferences.getString("eventList", "");
        if (csv == null || csv.isEmpty()) return new ArrayList<>();
        return new ArrayList<>(Arrays.asList(csv.split(",")));
    }

    // save the event list
    public void saveEventList(List<String> events) {
        String csv = TextUtils.join(",", events);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("eventList", csv);
        editor.commit();
    }

    // reset events list (used for debugging)
    public void clearEventList() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("eventList");
        editor.commit();
    }
}
