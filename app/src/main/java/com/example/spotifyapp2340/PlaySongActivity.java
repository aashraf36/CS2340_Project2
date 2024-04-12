package com.example.spotifyapp2340;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.widget.Button;

import java.io.IOException;

public class PlaySongActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(PlaySongActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Set up the button click listeners
        setupButtonListeners();
    }


    private void setupButtonListeners() {
        // Initialize each button and set its onClick listener to play the corresponding song
        findViewById(R.id.buttonSong1).setOnClickListener(v -> playSong("https://p.scdn.co/mp3-preview/497747cbf2e5a0db612d7355fe70d18368ba1ee8?cid=cfe923b2d660439caf2b557b21f3122"));
        findViewById(R.id.buttonSong2).setOnClickListener(v -> playSong("https://p.scdn.co/mp3-preview/bbeddf1d8b7dcf0eddb679fdf7affb0e7d4a94d7?cid=cfe923b2d660439caf2b557b21f31221"));
        findViewById(R.id.buttonSong3).setOnClickListener(v -> playSong("https://p.scdn.co/mp3-preview/e0017925ff70bc4a7d3f3eb64d757bc5d450db6c?cid=cfe923b2d660439caf2b557b21f31221"));
        findViewById(R.id.buttonSong4).setOnClickListener(v -> playSong("https://p.scdn.co/mp3-preview/56f0d556c3b8c3e6fdb05b027e4594d33d9a44d6?cid=cfe923b2d660439caf2b557b21f31221"));
        findViewById(R.id.buttonSong5).setOnClickListener(v -> playSong("https://p.scdn.co/mp3-preview/fc780d2d7634024c170723c769cca145d298e53f?cid=cfe923b2d660439caf2b557b21f31221"));
    }

    private void playSong(String url) {
        // Stop any currently playing song
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.release();
        }

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();  // prepare asynchronously to not block the main thread
            mediaPlayer.setOnPreparedListener(mp -> mediaPlayer.start());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
