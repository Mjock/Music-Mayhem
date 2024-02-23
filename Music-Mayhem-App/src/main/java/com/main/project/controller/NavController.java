package com.main.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
@Controller
public class NavController {
	   
	
	
@GetMapping("/map-register")
public String registerMapping(){
	return "register";
}
@GetMapping("/logout")
public String logout(HttpSession session) {
	session.invalidate();
	return "index";
}
@GetMapping("/map-login")
public String loginMapping(){
return "login";
}

@GetMapping("/map-songs")
public String songmapping(){
return "addsongs";
}
@GetMapping("/order")
public String order(){
return "makepayment";
}
@GetMapping("/forgotpassword")
public String forgotpassword(){
return "updatepassword";
}

@GetMapping("/adminhomeredirect")
public String adminhomeredirect(){
return "adminhome";
}

@GetMapping("/custhomeredirect")
public String custhomeredirect(){
return "customerhome";
}

}
