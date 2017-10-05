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

public class fifthActivity extends AppCompatActivity implements View.OnClickListener {
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        ImageView v1 = (ImageView) findViewById(R.id.train);
        v1.setOnClickListener(this);
        ImageView v2 = (ImageView) findViewById(R.id.zebra);
        v2.setOnClickListener(this);
        ImageView v3 = (ImageView) findViewById(R.id.queen);
        v3.setOnClickListener(this);
        ImageView v4 = (ImageView) findViewById(R.id.mobile);
        v4.setOnClickListener(this);
        Intent mIntent=getIntent();
        final int counter4 = mIntent.getIntExtra("scores", 0);
        CountDownTimer start = new CountDownTimer(15000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView mTextField=(TextView) findViewById(R.id.mTextField);
                //BreakIterator mTextField = new TextView(R.id.mTextField);
                mTextField.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                // BreakIterator mTextFieldnew = new TextView(R.id.mTextField);;
                TextView mTextField=(TextView) findViewById(R.id.mTextField);
                mTextField.setText("You lose:( Score is"+counter4);
            /*    final Toast toast = Toast.makeText(getApplicationContext(), "You lose:( Score is"+counter4, Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
             */   // mTextField.setText("You lose:( Score is"+counter5);
              /*  SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("key", counter4);
                editor.commit();
                finish();
               Intent mainIntent = new Intent(fifthActivity.this, eightActivity.class);
                startActivity(mainIntent);
*/
            }
        }.start();

    }
    public void onConnect2(final View v)
    {
        Intent mainIntent = new Intent(fifthActivity.this,LevelSelectorSpotWordActivity.class);
//                    mainIntent.putExtra("scores", counter);
        startActivity(mainIntent);
    }
    @Override
    public void onClick (View v){
        ImageView view = (ImageView) v;
        Intent mIntent=getIntent();
        final int counter4 = mIntent.getIntExtra("scores", 0);
        int counter5=counter4;
        switch (view.getId()) {
            case R.id.train:
                String s1 = view.getTag().toString();
                String strID1 = String.valueOf(s1.charAt(0));
                TextView tvId = (TextView) findViewById(R.id.t);
                String s = tvId.getTag().toString();
                String first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter5+=5;
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
                    int prevScore = superPass.getInt("swscore5", 0);
                    int prevLevel = superPass .getInt("swlevel", 0);
                    SharedPreferences.Editor edit = superPass.edit();
                    if (prevScore < counter5) {
                        edit.putInt("swscore5", counter5);
                    }
                    if(prevLevel < 5){
                        edit.putInt("swlevel", 5);
                    }
                    edit.apply();
                    Intent mainIntent = new Intent(fifthActivity.this, sixthActivity.class);
                    mainIntent.putExtra("scores", counter5);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    counter5--;
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
                tvId = (TextView) findViewById(R.id.t);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter5+=5;
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
                    Intent mainIntent = new Intent(fifthActivity.this, sixthActivity.class);
                    mainIntent.putExtra("scores", counter5);
                    startActivity(mainIntent);
                }
                else {
                    counter5--;
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
            case R.id.queen:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.t);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter5+=5;
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
                    Intent mainIntent = new Intent(fifthActivity.this, sixthActivity.class);
                    mainIntent.putExtra("scores", counter5);
                    startActivity(mainIntent);
                }
                else {
                    counter5--;
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
                tvId = (TextView) findViewById(R.id.t);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter5+=5;
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
                    Intent mainIntent = new Intent(fifthActivity.this, sixthActivity.class);
                    mainIntent.putExtra("scores", counter5);
                    startActivity(mainIntent);
                }
                else {
                    counter5--;
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
                        if(prevLevel < 5){
                            SharedPreferences.Editor edit = superPass.edit();
                            edit.putInt("swlevel", 5);
                            edit.apply();
                        }
                        Intent intent = new Intent(fifthActivity.this,LevelSelectorSpotWordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}