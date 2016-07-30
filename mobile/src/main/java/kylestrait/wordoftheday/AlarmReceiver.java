package kylestrait.wordoftheday;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by philb on 7/30/2016.
 */
public class AlarmReceiver extends BroadcastReceiver {

    public void onReceive(Context context, Intent intent) {
        WordOfMoment wordOfMoment = new WordOfMoment(context);

        CustomNotification cn = new CustomNotification(context, wordOfMoment.getTheWord());
    }

}
