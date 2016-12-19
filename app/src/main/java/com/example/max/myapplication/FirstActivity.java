package com.example.max.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    NotificationManager manager;
    Notification myNotication;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firt);



        manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);



        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);



        final Button button = (Button) findViewById(R.id.bt_main);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            public void onClick(View v) {

                Intent myIntent = new Intent(FirstActivity.this, MainActivity.class);
                FirstActivity.this.startActivity(myIntent);

                Intent intent = new Intent("com.rj.notitfications.SECACTIVITY");

                PendingIntent pendingIntent = PendingIntent.getActivity(FirstActivity.this, 1, intent, 0);

                Notification.Builder builder = new Notification.Builder(FirstActivity.this);

                builder.setAutoCancel(false);
                builder.setTicker("this is ticker text");
                builder.setContentTitle("Notification");
                builder.setContentText("You have clicked on the button");
                builder.setSmallIcon(R.drawable.hor);
                builder.setContentIntent(pendingIntent);
                builder.setOngoing(true);
                builder.setSubText("You can acces to you events");   //API level 16
                builder.setNumber(100);
                builder.build();

                myNotication = builder.getNotification();
                manager.notify(11, myNotication);





            }
        });
     }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.play_music:

                this.startService(new Intent(this, MusicService.class));

                Toast.makeText(getApplicationContext(), "Music on", Toast.LENGTH_SHORT).show();

                return true;

            case R.id.action_map:

                Intent myIntent = new Intent(FirstActivity.this, MapsActivity.class);
                FirstActivity.this.startActivity(myIntent);
                return true;


            case R.id.stop_music:

                this.stopService(new Intent(this, MusicService.class));
                Toast.makeText(getApplicationContext(), "Music off", Toast.LENGTH_SHORT).show();


                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

   }