// SongServiceImplementation.java
package com.main.project.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.main.project.entities.Songs;
import com.main.project.repositories.SongsRepository;

@Service
public class SongServiceImplementation implements SongService {

    @Autowired
    private SongsRepository songRepository;

    @Override
    public String addSongs(Songs song) {
    	// TODO Auto-generated method stub
    	songRepository.save(song);
    	return "Added";
    }
    public boolean songexist(String name) {
    	if(songRepository.findByName(name)==null) {
    		return false;
    	}
    	else
    	{
    		return true;
    	}
    }
    @Override
    public List<Songs> viewSongs() {
        return songRepository.findAll();
    }

    @Override
    public void updateSong(Songs song) {
        songRepository.save(song);
    }

    @Override
    public Songs getSongbyid(int songId) {
        return songRepository.findById(songId).orElse(null);
    }

    @Override
    public List<Songs> getFavoriteSongs() {
        return songRepository.findByIsFavoriteTrue();
    }

    @Override
    public void resetFavorites() {
        List<Songs> songs = songRepository.findAll();
        for (Songs song : songs) {
            song.setFavorite(false);
            songRepository.save(song);
        }
    }
<<<<<<< HEAD
	@Override
	public List<Songs> searchSongs(String query) {
		// TODO Auto-generated method stub
		return songRepository.findByNameContainingIgnoreCase(query);
	}
=======
>>>>>>> branch 'master' of https://github.com/Mjock/Music-Mayhem.git
}
