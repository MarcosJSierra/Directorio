/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import org.archteam.directorio.models.Anime;

/**
 *
 * @author marcos
 */
public interface AnimeService {
    
    public Anime getAnimeByID(Long id);
    
    public ArrayList<Anime> getAnimesByGenre(Long id);
    
    public ArrayList<Anime> getAnimesByType(Long id);
    
    public Anime createAnime(Anime anime);
    
    public Anime updateAnime(Anime anime);
    
    public void deleteAnime(Anime anime);
    
    public ArrayList<Anime> getAll();
    
}
