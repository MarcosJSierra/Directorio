/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import java.util.Set;
import org.archteam.directorio.models.Genre;

/**
 *
 * @author marcos
 */
public interface GenreService {
    
    public Genre getGenreById(Long id);
    
    public Set<Genre> getGenreByAnime(Long id);
    
    public Genre createGenre(Genre genre);
    
    public Genre updateGenre(Genre genre, Long id);
    
    public void deleteGenre(Long id);
    
    public ArrayList<Genre> getAll();
    
}
