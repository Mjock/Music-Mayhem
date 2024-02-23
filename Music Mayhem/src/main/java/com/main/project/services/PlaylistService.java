package com.main.project.services;

import java.util.List;

import com.main.project.entities.Playlist;

public interface PlaylistService {
public String addPlaylist(Playlist playlist);

public List<Playlist> fetchPlaylists();
}
