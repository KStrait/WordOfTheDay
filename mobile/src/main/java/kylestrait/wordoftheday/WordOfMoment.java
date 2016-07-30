package kylestrait.wordoftheday;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by philb on 7/30/2016.
 */
public class WordOfMoment {

    private Word theWord;
    private Context context;
    private Random random;

    public WordOfMoment(Context context) {
        this.context = context;
        random = new Random();
        setTheWord();
    }

    public Word getTheWord() {
        return theWord;
    }

    public void setTheWord() {
        String json = null;
        try {
            InputStream is = context.getAssets().open("providers.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try {
            JSONObject obj = new JSONObject(json);
            JSONArray m_jArry = obj.getJSONArray("wordlist");

            int randomNumber = random.nextInt(m_jArry.length());

            JSONObject jo_inside = m_jArry.getJSONObject(randomNumber);
            theWord.setName(jo_inside.getString("WORD"));
            theWord.setDefinition(jo_inside.getString("DEFINITION"));


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void saveTheWord() {
        //todo ass method to save theWord
    }
}
