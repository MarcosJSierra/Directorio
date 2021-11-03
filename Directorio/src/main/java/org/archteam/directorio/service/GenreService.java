/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import org.archteam.directorio.models.Genre;

/**
 *
 * @author marcos
 */
public interface GenreService {
    
    public Genre getGenreById(Long id);
    
    public ArrayList<Genre> getGenreByAnime(Long id);
    
    public Genre createGenre(Genre genre);
    
    public Genre updateGenre(Genre genre);
    
    public void delteGenre(Genre genre);
    
    public ArrayList<Genre> getAll();
    
}
