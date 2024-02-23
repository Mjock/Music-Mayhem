package com.main.project.services;





import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.project.entities.Songs;
import com.main.project.repositories.SongsRepository;


@Service
public class SongServiceImplementation implements SongService  {
@Autowired
SongsRepository srepo;

@Override
public String addSongs(Songs song) {
	// TODO Auto-generated method stub
	srepo.save(song);
	return "Added";
}
public boolean songexist(String name) {
	if(srepo.findByName(name)==null) {
		return false;
	}
	else
	{
		return true;
	}
}
@Override
public List<Songs> viewSongs() {
	List<Songs>songlist=srepo.findAll();
	return songlist;
}
@Override
public void updateSong(Songs song) {
	srepo.save(song);
	
}



}
