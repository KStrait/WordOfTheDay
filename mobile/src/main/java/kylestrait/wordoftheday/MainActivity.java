package kylestrait.wordoftheday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv_word = (TextView) findViewById(R.id.activity_main_tv_word);
        TextView tv_def = (TextView) findViewById(R.id.activity_main_tv_definition);

        WordOfMoment wordOfMoment = new WordOfMoment(this);
        Word word = wordOfMoment.getTheWord();

        Log.d("phil", "Word Name" + word.getName());

        tv_word.setText(word.getName());
        tv_def.setText(word.getDefinition());
    }
}
