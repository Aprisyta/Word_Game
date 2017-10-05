package com.example.android.kidd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.example.android.kidd.R.id.score;

public class GameCompleteActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_complete);
        TextView tvScore = (TextView) findViewById(score);
        SharedPreferences prefs = this.getSharedPreferences("Sunita", Context.MODE_PRIVATE);
        String username = prefs.getString("Username", null);
        String password = prefs.getString("Password", null);
        prefs = getSharedPreferences(username+password, Context.MODE_PRIVATE);
        MakeWordActivity obj = new MakeWordActivity();
        String s = (prefs.getString("mwscore", null));
        int c = obj.parseScore(s);
        tvScore.setText("Your score is: " + c);
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        Intent intent = new Intent(GameCompleteActivity.this, LevelSelectorMakeWordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}
