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

public class seventhActivity extends AppCompatActivity implements View.OnClickListener {
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);
        ImageView v1 = (ImageView) findViewById(R.id.crown);
        v1.setOnClickListener(this);
        ImageView v2 = (ImageView) findViewById(R.id.anchor);
        v2.setOnClickListener(this);
        ImageView v3 = (ImageView) findViewById(R.id.television);
        v3.setOnClickListener(this);
        ImageView v4 = (ImageView) findViewById(R.id.parrot);
        v4.setOnClickListener(this);
        Intent mIntent=getIntent();
        final int counter6 = mIntent.getIntExtra("scores", 0);
        CountDownTimer start = new CountDownTimer(5000, 1000) {

            public void onTick(long millisUntilFinished) {
                TextView mTextField=(TextView) findViewById(R.id.mTextField);
                //BreakIterator mTextField = new TextView(R.id.mTextField);
                mTextField.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }
            public void onFinish() {
                // BreakIterator mTextFieldnew = new TextView(R.id.mTextField);;
                TextView mTextField=(TextView) findViewById(R.id.mTextField);
                mTextField.setText("You lose:( Score is"+counter6);
         /*       final Toast toast = Toast.makeText(getApplicationContext(), "You lose:( Score is"+counter6, Toast.LENGTH_SHORT);
                toast.show();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
           */     // mTextField.setText("You lose:( Score is"+counter5);
                //      SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                //        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

            /*  SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("key", counter6);
                editor.commit();
                editor.clear().commit();
                Intent mainIntent = new Intent(seventhActivity.this, eightActivity.class);
                startActivity(mainIntent);
*/
            }
        }.start();

    }
    public void onConnect2(final View v)
    {
        Intent mainIntent = new Intent(seventhActivity.this,LevelSelectorSpotWordActivity.class);
//                    mainIntent.putExtra("scores", counter);
        startActivity(mainIntent);
    }
    @Override
    public void onClick (View v){
        ImageView view = (ImageView) v;
        Intent mIntent=getIntent();
        final int counter6 = mIntent.getIntExtra("scores", 0);
        int counter7=counter6;
        switch (view.getId()) {
            case R.id.crown:
                String s1 = view.getTag().toString();
                String strID1 = String.valueOf(s1.charAt(0));
                TextView tvId = (TextView) findViewById(R.id.a);
                String s = tvId.getTag().toString();
                String first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter7+=5;
                    //Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT).show();
                    final Toast toast = Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    Intent mainIntent = new Intent(seventhActivity.this, eightActivity.class);
                    mainIntent.putExtra("scores", counter7);
                    startActivity(mainIntent);
                }
                else {
                    counter7--;
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
            case R.id.anchor:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.a);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter7+=5;
                 /*   SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("key", counter7);
                    editor.commit();
*/
                    //Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT).show();
                    final Toast toast = Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT);
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
                    int prevScore = superPass.getInt("swscore7", 0);
                    int prevLevel = superPass .getInt("swlevel", 0);
                    SharedPreferences.Editor edit = superPass.edit();
                    if (prevScore < counter7) {
                        edit.putInt("swscore7", counter7);
                    }
                    if(prevLevel < 7){
                        edit.putInt("swlevel", 7);
                    }
                    edit.apply();
                    Intent mainIntent = new Intent(seventhActivity.this, LevelSelectorSpotWordActivity.class);
                    mainIntent.putExtra("scores", counter7);
                    startActivity(mainIntent);
                    finish();
                }
                else {
                    counter7--;
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
            case R.id.television:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.a);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first))
                {
                    counter7+=5;

                    // Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT).show();
                    final Toast toast = Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    Intent mainIntent = new Intent(seventhActivity.this, LevelSelectorSpotWordActivity.class);
                    mainIntent.putExtra("scores", counter7);
                    startActivity(mainIntent);
                }
                else {
                    counter7--;
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
                tvId = (TextView) findViewById(R.id.a);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter7+=5;

                    //Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT).show();
                    final Toast toast = Toast.makeText(getApplicationContext(), "Congratulations!! You cleared all levels", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
                    Intent mainIntent = new Intent(seventhActivity.this, eightActivity.class);
                    mainIntent.putExtra("scores", counter7);
                    startActivity(mainIntent);
            /*        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    //String textData = counter7;
                    int textData = counter7;

                    if (textData != 0) {
                        editor.putString(TEXT_DATA_KEY, textData.toString());
                        editor.commit();
                    }
                }*/
                    SharedPreferences prefs = this.getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putInt("key", counter7);
                    editor.commit();
                }
                else {
                    counter7--;
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
                        if(prevLevel < 7){
                            SharedPreferences.Editor edit = superPass.edit();
                            edit.putInt("swlevel", 7);
                            edit.apply();
                        }
                        Intent intent = new Intent(seventhActivity.this,LevelSelectorSpotWordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}