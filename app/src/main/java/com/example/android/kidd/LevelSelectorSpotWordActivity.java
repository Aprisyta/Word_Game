package com.example.android.kidd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class LevelSelectorSpotWordActivity extends AppCompatActivity implements View.OnClickListener{

    Button[] buttons;
    String password;
    String username;
    String spLogin;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selector_spot_word);
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
        if(sp.contains("swlevel")){
            level = sp.getInt("swlevel", 0);
        }
        else {
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("swlevel", 1);
            editor.putInt("swscore1", 0);
            editor.putInt("swscore2", 0);
            editor.putInt("swscore3", 0);
            editor.putInt("swscore4", 0);
            editor.putInt("swscore5", 0);
            editor.putInt("swscore6", 0);
            editor.putInt("swscore7", 0);
            editor.apply();
        }
        addListenersToButton(level);
    }

    public void addListenersToButton(int level) {
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
        sp = getSharedPreferences(spLogin, Context.MODE_PRIVATE);
        if(level > 7){
            level = 7;
        }
        for (int i = 0; i < level; i++){
            String temp1 = "swscore";
            temp1 += (i+1);
            String temp = buttons[i].getText().toString();
            int temp2 = sp.getInt(temp1, 0);
            temp = temp + "   " + "Best Score: " + temp2;
            buttons[i].setText(temp);
            buttons[i].setOnClickListener(this);
        }
//        for (int i = 6; i > level - 1; i--){
//            buttons[i].setBackgroundResource(R.drawable.buttonselector2);
//            buttons[i].setClickable(false);
//        }
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) findViewById(view.getId());
        String level = b.getText().toString();
        int number = Character.getNumericValue(level.charAt(6));
        Intent intent = null;
        switch (number){
            case 1:
                intent = new Intent(this, MainActivity.class);
                break;
            case 2:
                intent = new Intent(this, secActivity.class);
                break;
            case 3:
                intent = new Intent(this, thirdActivity.class);
                break;
            case 4:
                intent = new Intent(this, fourthActivity.class);
                break;
            case 5:
                intent = new Intent(this, fifthActivity.class);
                break;
            case 6:
                intent = new Intent(this, sixthActivity.class);
                break;
            case 7:
                intent = new Intent(this, seventhActivity.class);
                break;
        }
        startActivity(intent);
    }
}
