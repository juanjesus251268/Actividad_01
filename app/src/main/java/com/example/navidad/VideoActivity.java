package com.example.navidad;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        VideoView videoView = (VideoView) findViewById(R.id.videoView);

        Uri path = Uri.parse("android.resource://com.example.navidad/"
                + R.raw.video);

        MediaController mc = new MediaController(this);
        videoView.setMediaController(mc);

        videoView.setVideoURI(path);
        videoView.start();
    }
}