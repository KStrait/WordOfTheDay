package kylestrait.wordoftheday;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_word;
    private TextView tv_def;
    private WordOfMoment wordOfMoment;
    private Word word;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String activeWord = sharedPreferences.getString("word","");

        if(sharedPreferences.getString("firstRun","yes").equals("yes")) {
            firstRun();
        }

        if(!activeWord.equals("")) {
            getActiveWord(activeWord);
        }
        else{
            getNewWord();
        }
        tv_word = (TextView) findViewById(R.id.activity_main_tv_word);
        tv_def = (TextView) findViewById(R.id.activity_main_tv_definition);

        tv_word.setText(word.getName());
        tv_def.setText(word.getDefinition());

        CustomNotification cn = new CustomNotification(this, word);
    }

    public void getActiveWord(String wordName) {
        wordOfMoment = new WordOfMoment(this, wordName);
        word = wordOfMoment.getTheWord();
    }

    public void getNewWord() {
        wordOfMoment = new WordOfMoment(this);
        word = wordOfMoment.getTheWord();
    }

    public void firstRun() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("fistRun", "no");
        editor.commit();
        ScheduleNotification sn = new ScheduleNotification(this);
    }
}
