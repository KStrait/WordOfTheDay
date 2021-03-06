package kylestrait.wordoftheday;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * Created by philb on 7/30/2016.
 */
public class CustomNotification {

    public CustomNotification(Context context, Word word) {
        int notificationId = 001;
        Intent viewIntent = new Intent(context, MainActivity.class);
        viewIntent.putExtra("word", word.getName());

        PendingIntent viewPendingIntent =
                PendingIntent.getActivity(context, 0, viewIntent, 0);
        Log.i("phil", "Notification has extra: "+ viewIntent.hasExtra("word") );
        NotificationCompat.Builder notificationBuilder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Today's Word")
                        .setContentText(word.getName())
                        .setContentIntent(viewPendingIntent);

// Create a big text style for the second page
        NotificationCompat.BigTextStyle secondPageStyle = new NotificationCompat.BigTextStyle();
        secondPageStyle.setBigContentTitle(word.getName())
                .bigText(word.getDefinition());

// Create second page notification
        Notification secondPageNotification =
                new NotificationCompat.Builder(context)
                        .setStyle(secondPageStyle)
                        .build();

// Extend the notification builder with the second page
        Notification notification = notificationBuilder
                .extend(new NotificationCompat.WearableExtender()
                        .addPage(secondPageNotification))
                .build();
// Get an instance of the NotificationManager service
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(context);

// Build the notification and issues it with notification manager.
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}
