/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.archteam.directorio.models.Anime;
import org.archteam.directorio.models.Genre;
import org.archteam.directorio.repositories.AnimeRepository;
import org.archteam.directorio.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
@Service
public class GenreServiceImp implements GenreService {
    
    @Autowired
    public GenreRepository genreRepo;
    @Autowired
    public AnimeRepository animeRepo;
    
    @Override
    @Transactional(readOnly = true)
    public Genre getGenreById(Long id){
        return genreRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Set<Genre> getGenreByAnime(Long id){
        Anime anime = animeRepo.findById(id).orElse(null);
        if (anime == null){
            return null;
        }
        return anime.getGenres();
    }
    
    @Override
    @Transactional
    public Genre createGenre(Genre genre){
        return genreRepo.save(genre);
    }
    
    @Override
    @Transactional
    public Genre updateGenre(Genre newGenre, Long id){
        return genreRepo.findById(id)
                .map(genre -> {
                    genre.setDescription(newGenre.getDescription());
                    genre.setName(newGenre.getName());
                    return genreRepo.save(genre);
                }).orElseGet(() ->{ return newGenre;});
    }
    
    @Override
    @Transactional
    public void deleteGenre(Long id){
        Genre genre = genreRepo.getById(id);
        genreRepo.delete(genre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Genre> getAll(){
        return (ArrayList<Genre>) genreRepo.findAll();
    }
    
}
