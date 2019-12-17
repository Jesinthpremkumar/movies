package com.example.jasinthpremkumar.movies;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;



public class VideoAcitvity extends AppCompatActivity {
    VideoView videoView;
    MediaController mc;
    String url, site = "http://192.168.1.110:8081/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_acitvity);
        url = getIntent().getStringExtra("URL");

        /*try {
            url= URLEncoder.encode(url,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        url = url.replaceAll(" ", "%20");
        site = site + url;
        Toast.makeText(getApplication().getBaseContext(), site, Toast.LENGTH_LONG).show();
        videoView = findViewById(R.id.video);
        mc = new MediaController(this);
        videoView.setMediaController(mc);
        videoView.requestFocus();
        videoView.setVideoURI(Uri.parse(site));
        mc.show();
        videoView.start();

    }
}