// SongService.java
package com.main.project.services;

import java.util.List;
import com.main.project.entities.Songs;

public interface SongService {
    String addSongs(Songs song);
    boolean songexist(String name);
    List<Songs> viewSongs();
    void updateSong(Songs song);
    Songs getSongbyid(int songId);
    List<Songs> getFavoriteSongs();
    void resetFavorites();
}
