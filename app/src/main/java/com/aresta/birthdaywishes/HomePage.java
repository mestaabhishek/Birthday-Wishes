package com.aresta.birthdaywishes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HomePage extends AppCompatActivity {

    Button submitButton;
    EditText userNameTextBox, userDOBTextBox;
    String json;

    Gson gson = new Gson();
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        json = loadJSONFromRaw();
        user = gson.fromJson(json, User.class);

        VideoView videoView = (VideoView) findViewById(R.id.videoView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.birthday);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });

        userNameTextBox = (EditText) findViewById(R.id.Name);
        userDOBTextBox = (EditText) findViewById(R.id.Dob);
        submitButton = (Button) findViewById(R.id.button);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);

    }

    public void onClickSubmitButton (View view){
        if (user == null) {
            Toast.makeText(getApplicationContext(), "Error loading user data.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (userNameTextBox == null
                || userDOBTextBox == null
                || userNameTextBox.getText().toString().isEmpty()
                || userDOBTextBox.getText().toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Fill the details..!", Toast.LENGTH_SHORT).show();
        } else if (userNameTextBox.getText().toString().equals(user.getName())
                && userDOBTextBox.getText().toString().equals(user.getDob())) {
            Intent i = new Intent(this, CelebrationsPage.class);
            startActivity(i);
        } else if (!userNameTextBox.getText().toString().equals(user.getName())
                || !userDOBTextBox.getText().toString().equals(user.getDob())) {
            Toast.makeText(getApplicationContext(), "WRONG ENTRIES", Toast.LENGTH_SHORT).show();
        }
    }

    private String loadJSONFromRaw() {
        StringBuilder sb = new StringBuilder();
        try {
            InputStream is = getResources().openRawResource(R.raw.user);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;

            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}