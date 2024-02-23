package com.main.project.services;





import java.util.List;

import com.main.project.entities.Songs;

public interface SongService {
	public String addSongs(Songs song);
	public boolean songexist(String name);
	public List<Songs> viewSongs();
	public void updateSong(Songs song);
	
	
}
