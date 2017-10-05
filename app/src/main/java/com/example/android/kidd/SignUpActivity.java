package com.example.android.kidd;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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


public class SignUpActivity extends AppCompatActivity {

    EditText firstn;
    EditText lastn;
    EditText usern;
    EditText emailid;
    EditText pass;
    String firstName;
    String lastName;
    String userName;
    String emailId;
    String password;
    TextView tv;
    EditText rePass;
    String rePassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firstn = (EditText)findViewById(R.id.firstName);
        lastn = (EditText)findViewById(R.id.lastName);
        usern = (EditText)findViewById(R.id.username);
        emailid = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.password);
        tv = (TextView) findViewById(R.id.helper2);
        rePass = (EditText) findViewById(R.id.rePassword);
    }

    public void getInfo(View view){
        String toBeShown = "";
        firstName = firstn.getText().toString();
        lastName = lastn.getText().toString();
        userName = usern.getText().toString();
        emailId = emailid.getText().toString();
        password = pass.getText().toString();
        rePassword = rePass.getText().toString();
        if(firstName == null) {
            toBeShown = "Please enter First Name.";
            tv.setText(toBeShown);
            return;
        }
        if(firstName.equals("")) {
            toBeShown = "Please enter First Name.";
            tv.setText(toBeShown);
            return;
        }
        if(lastName == null) {
            toBeShown = "Please enter Last Name.";
            tv.setText(toBeShown);
            return;
        }
        if(lastName.equals("")) {
            toBeShown = "Please enter Last Name.";
            tv.setText(toBeShown);
            return;
        }
        if(userName == null) {
            toBeShown = "Please enter username.";
            tv.setText(toBeShown);
            return;
        }
        if (userName.equals("")) {
            toBeShown = "Please enter username.";
            tv.setText(toBeShown);
            return;
        }
        if(password == null) {
            toBeShown = "Please enter password.";
            tv.setText(toBeShown);
            return;
        }
        if(password.equals("")) {
            toBeShown = "Please enter password.";
            tv.setText(toBeShown);
            return;
        }
        if(rePassword == null) {
            toBeShown = "Please enter password again.";
            tv.setText(toBeShown);
            return;
        }
        if(rePassword.equals("")) {
            toBeShown = "Please enter password again.";
            tv.setText(toBeShown);
            return;
        }
        if(!rePassword.equals(password)){
            toBeShown = "Password must match.";
            tv.setText(toBeShown);
            return;
        }
        firstName = firstn.getText().toString();
        lastName = lastn.getText().toString();
        userName = usern.getText().toString();
        emailId = emailid.getText().toString();
        password = pass.getText().toString();
        rePassword = rePass.getText().toString();
        onConnect();
    }
    public void onConnect() {
        SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = superPass.edit();
        editor.putString("Username", userName);
        editor.putString("Password", password);
        editor.apply();
//        Toast.makeText(this, userName+password, Toast.LENGTH_SHORT).show();
        superPass = getSharedPreferences(userName+password, Context.MODE_PRIVATE);
        editor = superPass.edit();
        if(!superPass.contains("swlevel")){
            editor.putInt("swlevel", 1);
        }
        editor.apply();
        new Thread(){
            public void run(){
                HttpClient myClient = new DefaultHttpClient();
                HttpPost post = new HttpPost("https://kidster.herokuapp.com/signup");
                try {
                    List<NameValuePair> myArgs = new ArrayList<NameValuePair>();
                    myArgs.add(new BasicNameValuePair("firstname", firstName));
                    myArgs.add(new BasicNameValuePair("lastname", lastName));
                    myArgs.add(new BasicNameValuePair("username", userName));
                    myArgs.add(new BasicNameValuePair("email", emailId));
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
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
