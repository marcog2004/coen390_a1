package com.example.grecomarco_40285114_assignment1;
import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceHelper {

    private SharedPreferences sharedPreferences;

    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE );
    }

    public void resetAll() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();   // clears the whole file
        editor.apply();
    }


    public void saveButtonName(int number, String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("buttonName" + number, name);
        editor.commit();
    }

    public void saveTotalCount(int count) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("totalCount", count);
        editor.commit();
    }

    public void saveMaxCount(String maxCount){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("maxCount", maxCount);
        editor.commit();
    }

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

    public int getTotalCount() {
        return sharedPreferences.getInt("totalCount", 0);
    }

    public String getMaxCount() {
        return sharedPreferences.getString("maxCount", null);
    }

}
