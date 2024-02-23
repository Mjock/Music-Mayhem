package com.main.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.main.project.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist,Integer> {

}
