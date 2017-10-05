package com.example.android.kidd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GameSelectorActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_selector);
        SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
        String username = superPass.getString("Username", null);
        String password = superPass.getString("Password", null);
        String spLogin = username + password;
        superPass = getSharedPreferences(spLogin, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = superPass.edit();
        if(!superPass.contains("swlevel")){
            editor.putInt("swlevel", 1);
        }
        editor.apply();
    }

    public void startWordGame(View view){
        Intent intent = new Intent(this, LevelSelectorMakeWordActivity.class);
        startActivity(intent);
    }

    public void spotWordGame(View view){
        Intent intent = new Intent(this, LevelSelectorSpotWordActivity.class);
        startActivity(intent);
    }

}
