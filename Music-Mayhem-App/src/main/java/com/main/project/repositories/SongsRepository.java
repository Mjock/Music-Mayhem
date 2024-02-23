package com.main.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.project.entities.Songs;




public interface SongsRepository extends JpaRepository<Songs,Integer> {
	public Songs findByName(String name);

}
