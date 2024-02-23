package com.main.project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.project.entities.Playlist;
import com.main.project.repositories.PlaylistRepository;

@Service
public class PlaylistServiceImplementation implements PlaylistService {
	@Autowired
	PlaylistRepository playrepo;
	public String addPlaylist(Playlist playlist) {
		playrepo.save(playlist)	;
		return "Playlist is saved Successfully";
	}
	public List<Playlist> fetchPlaylists() {
		// TODO Auto-generated method stub
		return playrepo.findAll();
	}

}
