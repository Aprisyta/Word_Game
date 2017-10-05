package com.example.android.kidd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.apache.http.impl.client.DefaultHttpClient;

public class LevelSelectorMakeWordActivity extends AppCompatActivity implements View.OnClickListener {

    String password;
    String username;
    String userID;
    DefaultHttpClient client;
    SharedPreferences sp;
    String spLogin;
    Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selector_make_word);
        SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
        username = superPass.getString("Username", null);
        password = superPass.getString("Password", null);
        Log.d("Yay", "I am being called");
        spLogin = username + password;
        login();
    }

    private void login() {
        sp = getSharedPreferences(spLogin, Context.MODE_PRIVATE);
        int level = 1;
        if(sp.contains("mwscore")){
            level = sp.getInt("mwlevel", 0);
            //Toast.makeText(this, "Within if " + level, Toast.LENGTH_LONG).show();
        }
        else {
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("mwlevel", 1);
            editor.putString("mwscore", "");
            editor.apply();
        }
        addListenersToButton(level);
    }

    public void addListenersToButton(int level) {
        sp = getSharedPreferences(spLogin, Context.MODE_PRIVATE);

        buttons = new Button[7];
        Button l1 = (Button) findViewById(R.id.level1);
        buttons[0] = l1;
        Button l2 = (Button) findViewById(R.id.level2);
        buttons[1] = l2;
        Button l3 = (Button) findViewById(R.id.level3);
        buttons[2] = l3;
        Button l4 = (Button) findViewById(R.id.level4);
        buttons[3] = l4;
        Button l5 = (Button) findViewById(R.id.level5);
        buttons[4] = l5;
        Button l6 = (Button) findViewById(R.id.level6);
        buttons[5] = l6;
        Button l7 = (Button) findViewById(R.id.level7);
        buttons[6] = l7;
        String s = sp.getString("mwscore", null);
        Log.d("Find me ", sp.getString("mwscore", null) + level);
        int[] array = new int[level];
        if(s.equals("")){
            array[0] = 0;
        }
        else{
            for (int i = 0; i < s.length()-2; i=i+3){
                Log.v("Find me ", s.substring(i, i+3) + "    " + i/3);
                array[i/3] = Integer.parseInt(s.substring(i, i+3));
            }
        }
        for (int i = 0; i < level; i++){
            buttons[i].setOnClickListener(this);
            String temp = buttons[i].getText().toString();
            temp = temp + "   " + "Best Score: " + array[i];
            buttons[i].setText(temp);
        }
        for (int i = 6; i > level - 1; i--){
            buttons[i].setBackgroundResource(R.drawable.buttonselector2);
            buttons[i].setClickable(false);
        }
    }


    @Override
    public void onClick(View view) {
        Button b = (Button) findViewById(view.getId());
        String level = b.getText().toString();
        int number = Character.getNumericValue(level.charAt(6));
        int questionNumber = 0;
        switch (number){
            case 1:
                questionNumber = 1;
                break;
            case 2:
                questionNumber = 6;
                break;
            case 3:
                questionNumber = 11;
                break;
            case 4:
                questionNumber = 16;
                break;
            case 5:
                questionNumber = 21;
                break;
            case 6:
                questionNumber = 26;
                break;
            case 7:
                questionNumber = 31;
                break;
        }
        Intent intent = new Intent(this, MakeWordActivity.class).putExtra("intVariableName", questionNumber);
        startActivity(intent);
        finish();
    }
}
