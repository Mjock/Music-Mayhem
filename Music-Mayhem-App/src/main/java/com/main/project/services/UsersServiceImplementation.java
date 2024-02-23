package com.main.project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.project.entities.Users;
import com.main.project.repositories.UsersRepository;
@Service
public class UsersServiceImplementation implements UsersService  {

	@Autowired
	UsersRepository repo;
	public String addUser(Users user) {
		
		repo.save(user);
		return "user is created and saved";
	}
	
	public boolean emailExists(String email) {
		if(repo.findByEmail(email)==null) {
			return false;
		}
		else
		{
			return true;	
		}
	}

	public boolean validateUser(String email, String password) {
		
		if(repo.findByEmail(email).getPassword().equals(password)) {
			return true;
		}
		else 
		{
			return false;

		}
	}
	public String getRole(String email) {
		return (repo.findByEmail(email).getRole());
	}

	@Override
	public Users getUser(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
		
	}

	@Override
	public Users getUsername(String email) {
		// TODO Auto-generated method stub
		return repo.findByEmail(email);
		
	}

}
