package com.aresta.birthdaywishes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.IBinder;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.VideoView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WishesPage extends AppCompatActivity {
    MediaPlayer player;

    public IBinder onBind(Intent arg0) {
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wishes_page);

        final VideoView videoView = (VideoView) findViewById(R.id.crackersView);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.crackers);
        videoView.setVideoURI(uri);
        videoView.requestFocus();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.start();
            }
        });
        AdapterViewFlipper adapterViewFlipper = (AdapterViewFlipper) findViewById(R.id.Adapter);

        List<String> images = loadImagesFromAssets();
        FlipperAdapter adapter = new FlipperAdapter(this, images);

        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.startFlipping();

        player = MediaPlayer.create(this, R.raw.birthsong);
        player.setLooping(true);
        player.start();
        videoView.start();
        adapterViewFlipper.setAdapter(adapter);
        adapterViewFlipper.startFlipping();
    }
    class FlipperAdapter extends BaseAdapter {

        private List<String> images;
        private LayoutInflater inflater;

        FlipperAdapter(Context context, List<String> images) {
            this.images = images;
            inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public Object getItem(int position) {
            return images.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.flipper_items, parent, false);
            ImageView imageView = view.findViewById(R.id.Imageview);

            try {
                InputStream is = getAssets().open(images.get(position));
                Bitmap bitmap = BitmapFactory.decodeStream(is);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return view;
        }
    }


    @Override
    public void onBackPressed(){
        player.stop();
        Intent intent=new Intent(this, CelebrationsPage.class);
        startActivity(intent);
        super.onBackPressed();
    }

    private List<String> loadImagesFromAssets() {
        List<String> imageList = new ArrayList<>();
        try {
            String[] files = getAssets().list("pictures");
            if (files != null) {
                Arrays.sort(files); // keeps order
                for (String file : files) {
                    imageList.add("pictures/" + file);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }
}