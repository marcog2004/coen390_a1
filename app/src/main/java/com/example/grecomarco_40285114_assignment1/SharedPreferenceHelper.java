package com.example.grecomarco_40285114_assignment1;
import android.content.Context;
import android.content.SharedPreferences;


public class SharedPreferenceHelper {

    private SharedPreferences sharedPreferences;
    public SharedPreferenceHelper(Context context)
    {
        sharedPreferences = context.getSharedPreferences("ProfilePreference", Context.MODE_PRIVATE );
    }

    public void setButtonName(int number, String name){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("buttonName" + number, name);
        editor.commit();
    }

    public String getButtonName(int number) {
        switch (number) {
            case 1:
                return sharedPreferences.getString("buttonName1", "EVENT A");
            case 2:
                return sharedPreferences.getString("buttonName2", "EVENT B");
            case 3:
                return sharedPreferences.getString("buttonName3", "EVENT C");
            default:
                return "";
        }
    }
}
