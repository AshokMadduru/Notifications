package com.shok.notifications;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;

public class NotificationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);

        createNotification();
    }

    private void createNotification() {
        NotificationManager mNotificationManager =
                (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);

        // get default notification uri
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        // add small icon
                        .setSmallIcon(R.mipmap.ic_launcher)
                        // title of notification
                        .setContentTitle(getResources().getString(R.string.notification_title))
                        // description
                        .setContentText(getResources().getString(R.string.notification_desc))
                        // notificatin sound
                        .setSound(defaultSoundUri)
                        // add large icon
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(),
                                R.mipmap.ic_launcher));

       // NotificationCompat.
        Intent resultIntent = new Intent(this, NotificationsActivity.class);
        PendingIntent resultPendingIntent =
                PendingIntent.getActivity(
                        this,
                        0,
                        resultIntent,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );

        // set intent content to notification object
        mBuilder.setContentIntent(resultPendingIntent);

        // isssue notification to notification manager
        mNotificationManager.notify(1, mBuilder.build());
    }


}
