package com.example.spotifyapp2340.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.spotifyapp2340.ArtistsAdapter;
import com.example.spotifyapp2340.PlaySongActivity;  // Make sure this import is correct
import com.example.spotifyapp2340.TopTracksAdapter;
import com.example.spotifyapp2340.databinding.FragmentUnwrappedBinding;

public class UnwrappedFragment extends Fragment {

    private FragmentUnwrappedBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentUnwrappedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Set up adapters for RecyclerViews
        ArtistsAdapter artistsAdapter = new ArtistsAdapter();
        binding.recyclerViewArtists.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewArtists.setAdapter(artistsAdapter);
        artistsAdapter.loadUserTopArtists();

        TopTracksAdapter tracksAdapter = new TopTracksAdapter();
        binding.recyclerViewTopTracks.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerViewTopTracks.setAdapter(tracksAdapter);
        tracksAdapter.loadUserTopTracksThisWeek();

        // Setup the button click listener for the playSongs button
        binding.playSongs.setOnClickListener(v -> {
            Log.d("UnwrappedFragment", "Play Songs button clicked!");
            Toast.makeText(getContext(), "Play Songs button clicked!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), PlaySongActivity.class);
            startActivity(intent);
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Avoid memory leaks
    }
}