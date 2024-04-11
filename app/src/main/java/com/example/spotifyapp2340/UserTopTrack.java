package com.example.spotifyapp2340;


import java.util.List;

public class UserTopTrack {
    private String userId;
    private String name;
    private String playbackSound;

    // Constructors
    public UserTopTrack() {
        // Default constructor
    }

    public UserTopTrack(String userId, String name, String playbackSound) {
        this.userId = userId;
        this.name = name;
        this.playbackSound = playbackSound;
    }

    // Getters and setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaybackSound() {
        return playbackSound;
    }

    public void setPlaybackSound(String playbackSound) {
        this.playbackSound = playbackSound;
    }
}
