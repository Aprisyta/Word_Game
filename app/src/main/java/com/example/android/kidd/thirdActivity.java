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

public class thirdActivity extends AppCompatActivity implements View.OnClickListener {
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ImageView v1 = (ImageView) findViewById(R.id.ball);
        v1.setOnClickListener(this);
        ImageView v2 = (ImageView) findViewById(R.id.apple);
        v2.setOnClickListener(this);
        ImageView v3 = (ImageView) findViewById(R.id.parrot);
        v3.setOnClickListener(this);
        ImageView v4 = (ImageView) findViewById(R.id.mobile);
        v4.setOnClickListener(this);
        Intent mIntent=getIntent();
        final int counter2 = mIntent.getIntExtra("scores", 0);
        CountDownTimer start = new CountDownTimer(25000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView mTextField=(TextView) findViewById(R.id.mTextField);
                //BreakIterator mTextField = new TextView(R.id.mTextField);
                mTextField.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                // BreakIterator mTextFieldnew = new TextView(R.id.mTextField);;
                TextView mTextField=(TextView) findViewById(R.id.mTextField);
                mTextField.setText("You lose:( Score is"+counter2);
               /*final Toast toast = Toast.makeText(getApplicationContext(), "You lose:( Score is"+counter2, Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
               */ // mTextField.setText("You lose:( Score is"+counter5);
            /*    SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("key", counter2);
                editor.commit();
                Intent mainIntent = new Intent(thirdActivity.this, eightActivity.class);
                startActivity(mainIntent);
                finish();
            */}
        }.start();

    }
    public void onConnect2(final View v)
    {
        Intent mainIntent = new Intent(thirdActivity.this,LevelSelectorMakeWordActivity.class);
//                    mainIntent.putExtra("scores", counter);
        startActivity(mainIntent);
    }
    @Override
    public void onClick (View v){
        ImageView view = (ImageView) v;
        Intent mIntent=getIntent();
        final int counter2 = mIntent.getIntExtra("scores", 0);
        int counter3=counter2;
        switch (view.getId()) {
            case R.id.ball:
                String s1 = view.getTag().toString();
                String strID1 = String.valueOf(s1.charAt(0));
                TextView tvId = (TextView) findViewById(R.id.p);
                String s = tvId.getTag().toString();
                String first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter3+=5;
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
                    Intent mainIntent = new Intent(thirdActivity.this, fourthActivity.class);
                    mainIntent.putExtra("scores", counter3);
                    startActivity(mainIntent);
                }
                else {
                    counter3--;
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
            case R.id.apple:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.p);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter3+=5;
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
                    Intent mainIntent = new Intent(thirdActivity.this, fourthActivity.class);
                    mainIntent.putExtra("scores", counter3);
                    startActivity(mainIntent);
                }
                else {
                    counter3--;
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
            case R.id.parrot:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.p);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter3+=5;
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
                    SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
                    username = superPass.getString("Username", null);
                    password = superPass.getString("Password", null);
                    superPass = getSharedPreferences(String.valueOf(username+password), Context.MODE_PRIVATE);
                    int prevScore = superPass.getInt("swscore3", 0);
                    int prevLevel = superPass .getInt("swlevel", 0);
                    SharedPreferences.Editor edit = superPass.edit();
                    if (prevScore < counter3) {
                        edit.putInt("swscore3", counter3);
                    }
                    if(prevLevel < 3){
                        edit.putInt("swlevel", 3);
                    }
                    edit.apply();
                    Intent mainIntent = new Intent(thirdActivity.this, fourthActivity.class);
                    mainIntent.putExtra("scores", counter3);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    counter3--;
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
            case R.id.mobile:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.p);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter3+=5;
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
                    Intent mainIntent = new Intent(thirdActivity.this, fourthActivity.class);
                    mainIntent.putExtra("scores", counter3);
                    startActivity(mainIntent);
                }
                else {
                    counter3--;
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
                        if(prevLevel < 3){
                            SharedPreferences.Editor edit = superPass.edit();
                            edit.putInt("swlevel", 3);
                            edit.apply();
                        }
                        Intent intent = new Intent(thirdActivity.this,LevelSelectorSpotWordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}