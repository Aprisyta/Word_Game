package com.example.android.kidd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class secActivity extends AppCompatActivity implements View.OnClickListener {
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        ImageView v1 = (ImageView) findViewById(R.id.crown);
        v1.setOnClickListener(this);
        ImageView v2 = (ImageView) findViewById(R.id.zebra);
        v2.setOnClickListener(this);
        ImageView v3 = (ImageView) findViewById(R.id.train);
        v3.setOnClickListener(this);
        ImageView v4 = (ImageView) findViewById(R.id.watch);
        v4.setOnClickListener(this);
        Intent mIntent=getIntent();
        final int counter = mIntent.getIntExtra("scores", 0);
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        //final String scores = getIntent().getStringExtra("scores");
        CountDownTimer start = new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView mTextField=(TextView) findViewById(R.id.mTextField);
                //BreakIterator mTextField = new TextView(R.id.mTextField);
                mTextField.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                // BreakIterator mTextFieldnew = new TextView(R.id.mTextField);;
                TextView mTextField = (TextView) findViewById(R.id.mTextField);
                mTextField.setText("You lose!! Score is"+counter);
         /*       final Toast toast = Toast.makeText(getApplicationContext(), "You lose:( Score is"+counter, Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
           */     // mTextField.setText("You lose:( Score is"+counter5);
               /* SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("key", counter);
                editor.commit();
                finish();
                Intent mainIntent = new Intent(secActivity.this, eightActivity.class);
                startActivity(mainIntent);
               */ //finish();
            }
        }.start();

    }
    public void onConnect2(final View v)
    {
        Intent mainIntent = new Intent(secActivity.this,LevelSelectorSpotWordActivity.class);
//                    mainIntent.putExtra("scores", counter);
        startActivity(mainIntent);
    }
    @Override
    public void onClick (View v){
        ImageView view = (ImageView) v;
        Intent mIntent=getIntent();
        final int counter = mIntent.getIntExtra("scores", 0);
        int counter2=counter;
        switch (view.getId()) {
            case R.id.crown:
                String s1 = view.getTag().toString();
                String strID1 = String.valueOf(s1.charAt(0));
                TextView tvId = (TextView) findViewById(R.id.c);
                String s = tvId.getTag().toString();
                String first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter2+=5;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
                    username = superPass.getString("Username", null);
                    password = superPass.getString("Password", null);
                    superPass = getSharedPreferences(String.valueOf(username+password), Context.MODE_PRIVATE);
                    int prevScore = superPass.getInt("swscore2", 0);
                    int prevLevel = superPass .getInt("swlevel", 0);
                    SharedPreferences.Editor edit = superPass.edit();
                    if (prevScore < counter) {
                        edit.putInt("swscore2", counter);
                    }
                    if(prevLevel < 2){
                        edit.putInt("swlevel", 2);
                    }
                    edit.apply();
                    Intent mainIntent = new Intent(secActivity.this, thirdActivity.class);
                    mainIntent.putExtra("scores", counter2);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    counter2--;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                }
                break;
            case R.id.zebra:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.c);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    //Toast.makeText(getApplicationContext(), "Right Answer!!Congratulations", Toast.LENGTH_SHORT).show();
                    final Toast toast = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    Intent mainIntent = new Intent(secActivity.this, thirdActivity.class);
                    mainIntent.putExtra("scores", counter2);
                    startActivity(mainIntent);
                }
                else {
                    counter2--;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                }
                break;
            case R.id.train:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.c);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    //Toast.makeText(getApplicationContext(), "Right Answer!!Congratulations", Toast.LENGTH_SHORT).show();
                    final Toast toast = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    Intent mainIntent = new Intent(secActivity.this, thirdActivity.class);
                    mainIntent.putExtra("scores", counter2);
                    startActivity(mainIntent);
                }
                else {
                    counter2--;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                }
                break;
            case R.id.watch:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.c);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    //Toast.makeText(getApplicationContext(), "Right Answer!!Congratulations", Toast.LENGTH_SHORT).show();
                    final Toast toast = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    Intent mainIntent = new Intent(secActivity.this, thirdActivity.class);
                    mainIntent.putExtra("scores", counter2);
                    startActivity(mainIntent);
                }
                else {
                    counter2--;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Wrong Answer", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                }
                break;
        }


    }
    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?").setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
                        username = superPass.getString("Username",null);
                        password = superPass.getString("Password",null);
                        superPass = getSharedPreferences(String.valueOf(username+password), Context.MODE_PRIVATE);
                        int prevLevel = superPass .getInt("swlevel", 0);
                        if(prevLevel < 2){
                            SharedPreferences.Editor edit = superPass.edit();
                            edit.putInt("swlevel", 2);
                            edit.apply();
                        }
                        Intent intent = new Intent(secActivity.this,LevelSelectorSpotWordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }

}