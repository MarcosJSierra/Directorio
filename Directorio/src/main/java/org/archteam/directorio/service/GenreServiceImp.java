/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import org.archteam.directorio.models.Genre;
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
    
    @Override
    @Transactional(readOnly = true)
    public Genre getGenreById(Long id){
        return genreRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Genre> getGenreByAnime(Long id){
        return null;
    }
    
    @Override
    @Transactional
    public Genre createGenre(Genre genre){
        return genreRepo.save(genre);
    }
    
    @Override
    @Transactional
    public Genre updateGenre(Genre genre){
        return genreRepo.save(genre);
    }
    
    @Override
    @Transactional
    public void delteGenre(Genre genre){
        genreRepo.delete(genre);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Genre> getAll(){
        return (ArrayList<Genre>) genreRepo.findAll();
    }
    
}
