package kylestrait.wordoftheday;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_word;
    private TextView tv_def;
    private WordOfMoment wordOfMoment;
    private Word word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        if(intent.hasExtra("word")) {
            String activeWord = intent.getStringExtra("word");
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
}
