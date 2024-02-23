package com.main.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.project.entities.Songs;
import com.main.project.services.SongService;

@Controller
public class SongController {
	@Autowired
	SongService songserv;
	@PostMapping("/add-songs")
	public String addSongs(@ModelAttribute Songs song) {
		if(songserv.songexist(song.getName())==false) {
			songserv.addSongs(song);
			return "songsuccess";
		}
		else {
			return "songfailed";		}
	}
@GetMapping("/map-viewsongs")
public String viewsongs(Model model) {
	List<Songs> songslist=songserv.viewSongs();
	model.addAttribute("songslist", songslist);
	return "displaysongs";
}
@GetMapping("/viewsongs") 
public String viewCustomerSongs(Model model) {
	
		
		List<Songs> songslist=songserv.viewSongs();
		model.addAttribute("songslist", songslist);
		return "displaysongs";

}
}

