package ru.gelin.android.example.notification;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class NotificationActivity extends Activity {

    static final int NOTIFICATION_ID = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public void showNotification(View view) {
        Notification.Builder builder = new Notification.Builder(this);
        Intent intent = new Intent(this, NotificationActivity.class);
        builder.setContentTitle("Okidoki")
               .setContentText("Oki Doki Loki!")
               .setSmallIcon(R.drawable.pinkie)
               .setContentIntent(PendingIntent.getActivity(this, 0, intent, 0));
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.getNotification());
    }

    public void hideNotification(View view) {
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.cancel(NOTIFICATION_ID);
    }

}
