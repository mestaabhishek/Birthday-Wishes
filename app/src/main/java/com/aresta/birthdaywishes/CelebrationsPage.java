package com.aresta.birthdaywishes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class CelebrationsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_celebrations_page);

        VideoView crackersVideo = (VideoView) findViewById(R.id.crackersView);
        Uri crackersUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crackers);
        crackersVideo.setVideoURI(crackersUri);
        crackersVideo.requestFocus();
        crackersVideo.start();

        crackersVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        VideoView birthdayVideo = (VideoView) findViewById(R.id.birthdayView);
        Uri birthdayUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.happybirthday);
        birthdayVideo.setVideoURI(birthdayUri);
        birthdayVideo.requestFocus();
        birthdayVideo.start();

        birthdayVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
    }

    public void onClickNextButton(View view) {
        Intent intent=new Intent(this,WishesPage.class);
        startActivity(intent);
    }
    @Override
    public void onBackPressed(){
        Intent intent=new Intent(this,HomePage.class);
        startActivity(intent);
        super.onBackPressed();
    }
}