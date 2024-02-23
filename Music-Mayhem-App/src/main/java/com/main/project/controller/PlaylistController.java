package com.main.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.project.entities.Playlist;
import com.main.project.entities.Songs;
import com.main.project.services.PlaylistService;
import com.main.project.services.SongService;

@Controller
public class PlaylistController {
@Autowired
PlaylistService pserv;
	
@Autowired
SongService songserv;
	
	@GetMapping("/createplaylist")
public String createPlaylist(Model model) {
	List<Songs> songslist=songserv.viewSongs();
	model.addAttribute("songslist", songslist);
	return "createplaylist";
}
	@PostMapping("/addplaylist")
	public String addplaylist(@ModelAttribute Playlist playlist) {
		pserv.addPlaylist(playlist);
		List<Songs>songlist=playlist.getSong();
		
		for(Songs song:songlist){
			song.getPlaylist().add(playlist);
			songserv.updateSong(song);
		}
		return "playlistsuccess";
	}
	@GetMapping("/viewPlaylists")
	public String viewPlaylists(Model model) {
	List<Playlist>plist=pserv.fetchPlaylists();

	model.addAttribute("plist", plist);
	return "viewplaylists";
	}
	
	@GetMapping("/createcustplaylist")
public String createcustplaylist(Model model) {
	List<Songs> songslist=songserv.viewSongs();
	model.addAttribute("songslist", songslist);
	return "createcustplaylist";
}
	@PostMapping("/addcustplaylist")
	public String addcustplaylist(@ModelAttribute Playlist playlist) {
		pserv.addPlaylist(playlist);
		List<Songs>songlist=playlist.getSong();
		
		for(Songs song:songlist){
			song.getPlaylist().add(playlist);
			songserv.updateSong(song);
		}
		return "playlistsuccess";
	}

}
