package com.example.android.kidd;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MakeWordActivity extends AppCompatActivity implements View.OnClickListener {

    HashMap<Integer, ArrayList<String>> wordIndex;
    private Random random = new Random();
    Button[] buttonArray;
    TextView[] textViewArray;
    String currentWord;
    int counter = 0;
    LinearLayout textFieldTable;
    int questionNumber;
    int currentScore;
    int levelScore = 0;
    public int totalScore = 0;
    String password;
    String username;
    String currentGameString;
    int firstQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_word);
        Intent mIntent = getIntent();
        questionNumber = mIntent.getIntExtra("intVariableName", 0);
        firstQuestion = questionNumber;
        currentGameString = "";
        InputStream i = null;
        try {
            i = getAssets().open("objectName.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            inputWordsIntoArrayList(i);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SharedPreferences superPass = getSharedPreferences("Sunita", Context.MODE_PRIVATE);
        username = superPass.getString("Username", null);
        password = superPass.getString("Password", null);
        getRandomWord();
    }

    private void login() {
        SharedPreferences sp = getSharedPreferences(username + password, Context.MODE_PRIVATE);
        //updatelevel
        int prevLevel = sp.getInt("mwlevel", 0);
        int currentLevel = ((questionNumber - 1) / 5) + 1;
        SharedPreferences.Editor editor = sp.edit();
        if( currentLevel > prevLevel) {
            if(currentLevel == 8){
                editor.putInt("mwlevel", 7);
            }
            else{
                editor.putInt("mwlevel", currentLevel);
            }

        }
        //updatescore
        String stringPrevScore = sp.getString("mwscore", null);
        Log.d( "YU  ",currentGameString);
        if(levelScore == 100)
            currentGameString += "100";
        else if(levelScore > 9)
            currentGameString += "0" + levelScore;
        else
            currentGameString += "00" + levelScore;
        String stringCurrentScore = getUpdatedScore(prevLevel,currentLevel, stringPrevScore);
        totalScore = parseScore(stringCurrentScore);
        int prevScore = parseScore(stringPrevScore);
       // Log.v("Previous Score" + prevScore, "Current Score" + totalScore);
        if(totalScore > prevScore){
            editor.putString("mwscore", stringCurrentScore);
        }
        editor.apply();
        //Toast.makeText(this, Integer.toString(sp.getInt("mwlevel", 0)) + "   " + sp.getString("mwscore", null), Toast.LENGTH_LONG).show();
        //Toast.makeText(this, , Toast.LENGTH_LONG).show();
    }

    private String getUpdatedScore(int prevLevel, int currentLevel, String stringPrevScore) {
        Log.d(stringPrevScore + "Prev", "    " + currentGameString  + " Current");
        int startLevel = ((firstQuestion - 1)/5) + 1;
        int startIndex = (startLevel-1) * 3;
        String s = "";
        if(currentLevel > prevLevel){
            int indexCurrentSScore = 0;
            s = stringPrevScore.substring(0, startIndex);
            for (int i = startIndex; i < stringPrevScore.length(); i = i+3){
                if(Integer.parseInt(stringPrevScore.substring(i, i+3)) < Integer.parseInt(currentGameString.substring(indexCurrentSScore, indexCurrentSScore + 3))){
                    s += currentGameString.substring(indexCurrentSScore, indexCurrentSScore + 3);
                }
                else
                    s += stringPrevScore.substring(i, i+3);
                indexCurrentSScore += 3;
            }
            s += currentGameString.substring(indexCurrentSScore);
        }
        else if(currentLevel == prevLevel){
            int indexCurrentSScore = 0;
            s = stringPrevScore.substring(0, startIndex);
            for (int i = startIndex; i < stringPrevScore.length(); i = i+3){
                if(Integer.parseInt(stringPrevScore.substring(i, i+3)) < Integer.parseInt(currentGameString.substring(indexCurrentSScore, indexCurrentSScore + 3))){
                    s += currentGameString.substring(indexCurrentSScore, indexCurrentSScore + 3);
                }
                else
                    s += stringPrevScore.substring(i, i+3);
                indexCurrentSScore += 3;
            }
        }
        else {
            int indexCurrentSScore = 0;
            s = stringPrevScore.substring(0, startIndex);
            for (int i = startIndex; i < currentGameString.length() + startIndex; i = i+3){
                if(Integer.parseInt(stringPrevScore.substring(i, i+3)) < Integer.parseInt(currentGameString.substring(indexCurrentSScore, indexCurrentSScore + 3))){
                    s += currentGameString.substring(indexCurrentSScore, indexCurrentSScore + 3);
                }
                else
                    s += stringPrevScore.substring(i, i+3);
                indexCurrentSScore += 3;
            }
            s += stringPrevScore.substring(indexCurrentSScore);
        }
        return s;
    }

    public int parseScore(String prevScore) {
        int score = 0;
        for (int i = 0; i < prevScore.length(); i=i+3){
            score += Integer.parseInt(prevScore.substring(i, i+3));
        }
        return score;
    }

    public void inputWordsIntoArrayList(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        wordIndex = new HashMap<>();
        for (int i = 3; i < 11; i++) {
            wordIndex.put(i, new ArrayList<String>());
        }
        String line;
        while ((line = in.readLine()) != null) {
            int wordLength = line.trim().length();
            wordIndex.get(wordLength).add(line.trim());
        }
    }

    public void getRandomWord() {
        if(questionNumber != firstQuestion && (questionNumber % 5 == 1) && questionNumber != 36) {
            String adder = "";
            if(levelScore == 100)
                adder = "100";
            else if(currentScore > 9)
                adder = "0" + levelScore;
            else
                adder = "00" + levelScore;
            currentGameString += adder;
            levelScore = 0;
        }
        currentScore = 20;
        int levelDecider = ((questionNumber - 1) / 5) + 1;
        int lengthOfWord = 0;
        switch (levelDecider) {
            case 1:
                lengthOfWord = 3;
                break;

            case 2:
                lengthOfWord = 4;
                break;

            case 3:
                lengthOfWord = 5;
                break;

            case 4:
                lengthOfWord = 6;
                break;

            case 5:
                lengthOfWord = 7;
                break;

            case 6:
                lengthOfWord = 8;
                break;

            case 7:
                lengthOfWord = 9;
                break;

            case 8:
                lengthOfWord = 10;
                break;
        }
        int index = random.nextInt(wordIndex.get(lengthOfWord).size());
        currentWord = wordIndex.get(lengthOfWord).get(index);
        wordIndex.get(lengthOfWord).remove(index);
        questionNumber++;
        getImage(currentWord);
        setTextFields(currentWord);
        setValueToButtons();
    }

    private void setTextFields(String currentWord) {
        textFieldTable = (LinearLayout) findViewById(R.id.textContainer);
        textViewArray = new TextView[currentWord.length()];
        for (int i = 0; i < currentWord.length(); i++) {
            TextView text = new TextView(this);
            text.setPadding(7, 7, 7, 7);
            text.setTextSize(20f);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1f);
            params.setMargins(4, 4, 4, 4);
            text.setLayoutParams(params);
            text.setBackgroundResource(R.drawable.textviewbg);
            text.setTextColor(Color.parseColor("#fac0c0"));
            text.setText("-1");
            textViewArray[i] = text;
            textFieldTable.addView(text);
        }
    }

    public void getImage(String currentWord) {
        ImageView image = (ImageView) findViewById(R.id.image);
        String uri = "drawable/" + currentWord;
        int imageResource = getResources().getIdentifier(uri, null, getPackageName());
        image.setImageResource(imageResource);
    }

    public void setValueToButtons() {
        buttonArray = new Button[10];
        Button currentButton = (Button) findViewById(R.id.button0);
        buttonArray[0] = currentButton;
        currentButton = (Button) findViewById(R.id.button1);
        buttonArray[1] = currentButton;
        currentButton = (Button) findViewById(R.id.button2);
        buttonArray[2] = currentButton;
        currentButton = (Button) findViewById(R.id.button3);
        buttonArray[3] = currentButton;
        currentButton = (Button) findViewById(R.id.button4);
        buttonArray[4] = currentButton;
        currentButton = (Button) findViewById(R.id.button5);
        buttonArray[5] = currentButton;
        currentButton = (Button) findViewById(R.id.button6);
        buttonArray[6] = currentButton;
        currentButton = (Button) findViewById(R.id.button7);
        buttonArray[7] = currentButton;
        currentButton = (Button) findViewById(R.id.button8);
        buttonArray[8] = currentButton;
        currentButton = (Button) findViewById(R.id.button9);
        buttonArray[9] = currentButton;
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setOnClickListener(this);
            buttonArray[i].setBackgroundResource(R.drawable.buttonselector);
        }
        HashMap<Integer, Boolean> buttonVisited = new HashMap<>();
        for (int index = 0; index < buttonArray.length; index++) {
            buttonVisited.put(index, false);
        }
        char[] charArrayOfCurrentWord = currentWord.toCharArray();
        Arrays.sort(charArrayOfCurrentWord);
        String sortedCurrentWord = String.valueOf(charArrayOfCurrentWord);
        for (int i = 0; i < sortedCurrentWord.length(); i++) {
            int randomButtonSelector = random.nextInt(buttonArray.length);
            while (buttonVisited.get(randomButtonSelector)) {
                randomButtonSelector = random.nextInt(buttonArray.length);
            }
            buttonArray[randomButtonSelector].setText(sortedCurrentWord.charAt(i) + "");
            buttonVisited.put(randomButtonSelector, true);
        }
        while (!doAllButtonsHaveText(buttonArray)) {
            String alphabets = "abcdefghijklmnopqrstuvwxyz";
            int randIndex = random.nextInt(alphabets.length());
            int randomButtonSelector = random.nextInt(buttonArray.length);
            while (buttonVisited.get(randomButtonSelector)) {
                randomButtonSelector = random.nextInt(buttonArray.length);
            }
            buttonArray[randomButtonSelector].setText(alphabets.charAt(randIndex) + "");
        }
    }

    public boolean doAllButtonsHaveText(Button[] buttonArray) {
        for (int i = 0; i < buttonArray.length; i++) {
            if (buttonArray[i].getText() == "") {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onClick(final View view) {
        Button b = (Button) findViewById(view.getId());
        if (counter <= currentWord.length() - 1) {
            b.setBackgroundResource(R.drawable.buttonselector2);
            b.setClickable(false);
            textViewArray[counter].setText(b.getText().toString().toUpperCase());
            textViewArray[counter].setTextColor(Color.BLACK);
            if (counter < currentWord.length() - 1) {
                counter++;
            } else {
                counter = 1000;
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        play(view);
                    }
                }, 1000);
            }
        }
    }

    public void play(View view) {
        counter = 0;
        boolean decider = checkValidityOfWord();
        if (decider) {
            totalScore = totalScore + currentScore;
            levelScore += currentScore;
            Toast.makeText(this, "Yes correct word formed!", Toast.LENGTH_SHORT).show();
            if(questionNumber > 35){
                login();
                Intent intent = new Intent(this, GameCompleteActivity.class);
                startActivity(intent);
                finish();
            }
            nextImage();
        } else {
            currentScore = currentScore - 5;
            if(currentScore == 0){
                Toast.makeText(this, "Oops! You could not guess the word. You will be given next question now!", Toast.LENGTH_LONG).show();
                nextImage();
            }
            Toast.makeText(this, "Try again", Toast.LENGTH_SHORT).show();
            reset(view);
        }
    }

    private void nextImage() {
        if (textFieldTable.getChildCount() > 0) {
            textFieldTable.removeAllViews();
        }
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setText("");
        }
        getRandomWord();
    }

    private boolean checkValidityOfWord() {
        String matcher = "";
        for (int i = 0; i < currentWord.length(); i++) {
            matcher += textViewArray[i].getText().toString().toLowerCase();
        }
        if (matcher.equals(currentWord)) {
            return true;
        } else
            return false;
    }

    public void reset(View view) {
        counter = 0;
        if (textFieldTable.getChildCount() > 0)
            textFieldTable.removeAllViews();
        for (int i = 0; i < buttonArray.length; i++) {
            buttonArray[i].setBackgroundResource(R.drawable.buttonselector);
            buttonArray[i].setClickable(true);
        }
        setTextFields(currentWord);
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setTitle("Really Exit?")
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        login();
                        Intent intent = new Intent(MakeWordActivity.this, LevelSelectorMakeWordActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }).create().show();
    }
}
