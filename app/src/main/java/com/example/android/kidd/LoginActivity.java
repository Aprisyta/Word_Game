package com.example.android.kidd;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    public static DefaultHttpClient myClient;
    String userName;
    String password;
    String userID;
    EditText usern;
    EditText pass;
    TextView helper;
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = (TextView) findViewById(R.id.helper);
        usern = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        Button suButton = (Button) findViewById(R.id.register_button);
        suButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void getIdPass(View view) {
        String toBeShown = "";
        userName = usern.getText().toString();
        password = pass.getText().toString();
        if (userName == null) {
            toBeShown = "Please enter username.";
            helper.setText(toBeShown);
            return;
        }
        if (userName.equals("")) {
            toBeShown = "Please enter username.";
            helper.setText(toBeShown);
            return;
        }
        if (password == null) {
            toBeShown = "Please enter password.";
            helper.setText(toBeShown);
            return;
        }
        if (password.equals("")) {
            toBeShown = "Please enter password.";
            helper.setText(toBeShown);
            return;
        }
        userName = usern.getText().toString();
        password = pass.getText().toString();
//        Toast.makeText(this, userName+password, Toast.LENGTH_SHORT).show();
        sp = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Username", userName);
        editor.putString("Password", password);
        editor.apply();
        SharedPreferences child = getSharedPreferences(userName + password, Context.MODE_PRIVATE);
        if(!child.contains("swlevel")){
            toBeShown = "Please signup";
            helper.setText(toBeShown);
            return;
        }
        onLogin();
    }

    public int onLogin() {
        sp = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Username", userName);
        editor.putString("Password", password);
        editor.apply();
        new Thread() {
            public void run() {
                HttpClient myClient = new DefaultHttpClient();
                HttpPost post = new HttpPost("https://kidster.herokuapp.com/login");
                try {
                    List<NameValuePair> myArgs = new ArrayList<>();
                    myArgs.add(new BasicNameValuePair("username", userName));
                    myArgs.add(new BasicNameValuePair("password", password));
                    post.setEntity(new UrlEncodedFormEntity(myArgs));
                    HttpResponse myResponse = myClient.execute(post);
                    BufferedReader br = new BufferedReader(new InputStreamReader(myResponse.getEntity().getContent()));
                    String line = "";
                    while ((line = br.readLine()) != null) {
                        Log.d("mytag", line);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (ClientProtocolException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        Intent intent = new Intent(this, GameSelectorActivity.class);
        startActivity(intent);
        finish();
        return 0;
    }
}

