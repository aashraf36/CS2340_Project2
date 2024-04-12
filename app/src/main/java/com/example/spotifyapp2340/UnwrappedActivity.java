package com.example.spotifyapp2340;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class UnwrappedActivity extends AppCompatActivity {

    private Button buttonPlay;
    private RecyclerView recyclerViewArtists, recyclerViewArtists2, recyclerViewArtists3;
    private RecyclerView recyclerViewTopTracks, recyclerViewTopTracks2, recyclerViewTopTracks3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_unwrapped);

        // Initialize RecyclerViews for artists
        recyclerViewArtists = findViewById(R.id.recyclerViewArtists);
        recyclerViewArtists2 = findViewById(R.id.recyclerViewArtists2);
        recyclerViewArtists3 = findViewById(R.id.recyclerViewArtists3);

        // Initialize RecyclerViews for tracks
        recyclerViewTopTracks = findViewById(R.id.recyclerViewTopTracks);
        recyclerViewTopTracks2 = findViewById(R.id.recyclerViewTopTracks2);
        recyclerViewTopTracks3 = findViewById(R.id.recyclerViewTopTracks3);

        // Initialize the button to play songs and set onClick listeners
        buttonPlay = findViewById(R.id.play_Songs); // Make sure the ID matches your layout
        buttonPlay.setOnClickListener(v -> {
            Log.d("UnwrappedActivity", "Play Songs Button clicked!");
            Toast.makeText(UnwrappedActivity.this, "Play Songs Button clicked!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UnwrappedActivity.this, PlaySongActivity.class);
            startActivity(intent);
        });

        // Set up RecyclerViews (Assuming you have some Adapter class ready)
        // setupRecyclerView(recyclerViewArtists, new YourArtistAdapter());
        // setupRecyclerView(recyclerViewArtists2, new YourArtistAdapter());
        // setupRecyclerView(recyclerViewArtists3, new YourArtistAdapter());

        // setupRecyclerView(recyclerViewTopTracks, new YourTracksAdapter());
        // setupRecyclerView(recyclerViewTopTracks2, new YourTracksAdapter());
        // setupRecyclerView(recyclerViewTopTracks3, new YourTracksAdapter());

        // Additional initialization and logic to load data into RecyclerViews if necessary
    }

    // Helper method to setup RecyclerView with an adapter
    private void setupRecyclerView(RecyclerView recyclerView, RecyclerView.Adapter adapter) {
        recyclerView.setHasFixedSize(true); // For performance improvements
        recyclerView.setAdapter(adapter);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this)); // Assuming a vertical list
    }

    // Include other methods like getToken, getCode, onActivityResult, etc.

    // Rest of your activity code...
}

// Include other methods like getToken, getCode, onActivityResult, etc.

    // Rest of your activity code...

