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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String username;
    String password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView v1 = (ImageView) findViewById(R.id.apple);
        v1.setOnClickListener(this);
        ImageView v2 = (ImageView) findViewById(R.id.rat);
        v2.setOnClickListener(this);
        ImageView v3 = (ImageView) findViewById(R.id.queen);
        v3.setOnClickListener(this);
        ImageView v4 = (ImageView) findViewById(R.id.ball);
        v4.setOnClickListener(this);
        start.start();
    }

    CountDownTimer start = new CountDownTimer(35000, 1000) {

        public void onTick(long millisUntilFinished) {
            TextView mTextField = (TextView) findViewById(R.id.mTextField);
            //BreakIterator mTextField = new TextView(R.id.mTextField);
            mTextField.setText("Seconds remaining: " + millisUntilFinished / 1000);
        }

        public void onFinish() {
            // BreakIterator mTextFieldnew = new TextView(R.id.mTextField);
            TextView mTextField = (TextView) findViewById(R.id.mTextField);
            //  mTextField.setText("Sorry"+":("+" You lose!");
          /*     final Toast toast = Toast.makeText(getApplicationContext(), "You lose:( Score is"+0, Toast.LENGTH_SHORT);
               toast.show();
               Handler handler = new Handler();
               handler.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       toast.cancel();
                   }
               }, 1000);
            */   //
            mTextField.setText("You lose:( Score is" + 0);

//            SharedPreferences prefs = getSharedPreferences("myPrefsKey", Context.MODE_PRIVATE);
//            SharedPreferences.Editor editor = prefs.edit();
//            editor.putInt("key", 0);
//            editor.commit();
//            finish();
//            Intent mainIntent = new Intent(MainActivity.this, eightActivity.class);
//            startActivity(mainIntent);
//          //  finish();
        }
    };

    public void onConnect2(final View v) {
        Intent mainIntent = new Intent(MainActivity.this, LevelSelectorSpotWordActivity.class);
//                    mainIntent.putExtra("scores", counter);
        startActivity(mainIntent);
    }

    @Override
    public void onClick(View v) {
        ImageView view = (ImageView) v;
        int counter = 0;
        boolean flag = false;
        switch (view.getId()) {
            case R.id.apple:
                String s1 = view.getTag().toString();
                String strID1 = String.valueOf(s1.charAt(0));
                TextView tvId = (TextView) findViewById(R.id.r);
                String s = tvId.getTag().toString();
                String first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter = counter + 5;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
//                    Intent mainIntent = new Intent(MainActivity.this, secActivity.class);
//                    mainIntent.putExtra("scores", counter);
//                    startActivity(mainIntent);
                    flag = true;
                } else {
                    counter--;
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
            case R.id.rat:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.r);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter = counter + 5;
                    //ogin();
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
                    superPass = getSharedPreferences(String.valueOf(username + password), Context.MODE_PRIVATE);
                    int prevScore = superPass.getInt("swscore1", 0);
                    int prevLevel = superPass .getInt("swlevel", 0);
                    SharedPreferences.Editor edit = superPass.edit();
                    if (prevScore < counter) {
                        edit.putInt("swscore1", counter);
                    }
                    if(prevLevel < 1){
                        edit.putInt("swlevel", 1);
                    }
                    edit.apply();
                    Intent mainIntent = new Intent(MainActivity.this, secActivity.class);
                    mainIntent.putExtra("scores", counter);
                    startActivity(mainIntent);
                    finish();
//                    Intent mainIntent = new Intent(MainActivity.this, secActivity.class);
//                    mainIntent.putExtra("scores", counter);
//                    //   Toast.makeText(getApplicationContext(), counter, Toast.LENGTH_SHORT).show();
//                    startActivity(mainIntent);
                    flag = true;
                } else {
                    counter--;
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
                tvId = (TextView) findViewById(R.id.r);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter = counter + 5;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
//                    Intent mainIntent = new Intent(MainActivity.this, secActivity.class);
//                    mainIntent.putExtra("scores", counter);
//                    startActivity(mainIntent);
                    flag = true;
                } else {
                    counter--;
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
            case R.id.ball:
                s1 = view.getTag().toString();
                strID1 = String.valueOf(s1.charAt(0));
                tvId = (TextView) findViewById(R.id.r);
                s = tvId.getTag().toString();
                first = String.valueOf(s.charAt(0));
                if (strID1.equals(first)) {
                    counter = counter + 5;
                    final Toast toast = Toast.makeText(getApplicationContext(), "Right Answer", Toast.LENGTH_SHORT);
                    toast.show();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            toast.cancel();
                        }
                    }, 1000);
//                    Intent mainIntent = new Intent(MainActivity.this, secActivity.class);
//                    mainIntent.putExtra("scores", counter);
//                    startActivity(mainIntent);
                    flag = true;
                } else {
                    counter--;
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
 /*       if (flag) {
            SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
            username = superPass.getString("Username", null);
            password = superPass.getString("Password", null);
            superPass = getSharedPreferences(String.valueOf(username+password), Context.MODE_PRIVATE);
            int prevScore = superPass.getInt("swscore1", 0);
            if(prevScore < counter){
                SharedPreferences.Editor edit = superPass.edit();
                edit.putInt("swscore1", counter);
                edit.putInt("swlevel", 1);
            }
            Intent mainIntent = new Intent(MainActivity.this, secActivity.class);
            mainIntent.putExtra("scores", counter);
            startActivity(mainIntent);
            finish();
        }
        // return spLogin;
    }
*/
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
                        if(prevLevel == 1){
                            SharedPreferences.Editor edit = superPass.edit();
                            edit.putInt("swlevel", 1);
                            edit.apply();
                        }
                        Intent intent = new Intent(MainActivity.this,LevelSelectorSpotWordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}
