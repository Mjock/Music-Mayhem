package com.main.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.project.entities.Songs;




public interface SongsRepository extends JpaRepository<Songs,Integer> {
	public Songs findByName(String name);
	public List<Songs> findByIsFavoriteTrue();
}
