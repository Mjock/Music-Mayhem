package com.main.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.project.entities.Playlist;
import com.main.project.entities.Songs;
import com.main.project.entities.Users;
import com.main.project.services.PlaylistService;
import com.main.project.services.SongService;
import com.main.project.services.UsersService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {
	@Autowired
	UsersService userv;
	
	@Autowired
	SongService songv;
	
	@Autowired
	PlaylistService pserv;

@PostMapping("/register")
public String adduser(@ModelAttribute Users user )
{
	
	if(userv.emailExists(user.getEmail())==false) {
	userv.addUser(user);
	System.out.println("User added");
	return "registersuccess";
	}
	else
	{
		return "registerfail";
	}
	
	}

@PostMapping("/login")
public String validateUser(@RequestParam String email,@RequestParam String password,HttpSession session ){
	
if(userv.emailExists(email)==true) {
	if(userv.validateUser(email, password)==true) {
	Users user=userv.getUsername(email);
	String username=user.getUsername();
	session.setAttribute("username", username);
	session.setAttribute("email", email);
	if(userv.getRole(email).equals("admin")) {
		return "adminhome";
	}
	else {
		return "customerhome";
	}
	}
	else
	{
		return "loginfail";

	}

}
else
{
	return "emailnotexist";
}
}
@GetMapping("/explorepremium")
public String exploresongs(HttpSession session) {
	
	String email=(String) session.getAttribute("email");
	      Users user = userv.getUser(email); 
	      boolean userStatus=user.isPremium();
	      if(userStatus==true) {
	    	  return "premiumpage";
	      }
	      else
	      {
	    	  return "makepayment";
	      }
}

@GetMapping("/viewcustsongs")
public String viewsongs(Model model) {
	List<Songs>songslist=songv.viewSongs();
	model.addAttribute("songslist", songslist);
	return "viewcustsongs";
}

@PostMapping("/updatepassword")
public String updatepassword(@RequestParam String email,@RequestParam String password,@RequestParam String uniquechar) {
	Users user=userv.getUser(email);
	String originalchar=user.getUniquechar();
	if(uniquechar.equals(originalchar)) {
	user.setPassword(password);
	userv.updateUser(user);
	return "updatedsuccessfully";
	}else
	{
		return "passwordupdatefailed";
	}
	
}
@GetMapping("/viewcustPlaylists")
public String viewcustPlaylists(Model model) {
List<Playlist>plist=pserv.fetchPlaylists();

model.addAttribute("plist", plist);
return "viewcustplaylist";
}
}
