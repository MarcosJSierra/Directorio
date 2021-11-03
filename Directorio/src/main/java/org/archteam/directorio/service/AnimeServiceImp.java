/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import org.archteam.directorio.models.Anime;
import org.archteam.directorio.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 *
 * @author marcos
 */
@Service
public class AnimeServiceImp implements AnimeService{
    
    @Autowired
    public AnimeRepository animeRepo;
    
    @Override
    @Transactional(readOnly = true)
    public Anime getAnimeByID(Long id){
        return animeRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Anime> getAnimesByGenre(Long id){
        return null;
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Anime> getAnimesByType(Long id){
        return null;
    }
    
    @Override
    @Transactional
    public Anime createAnime(Anime anime){
        return animeRepo.save(anime);
    }
    
    @Override
    @Transactional
    public Anime updateAnime(Anime anime){
        return animeRepo.save(anime);
    }
    
    @Override
    @Transactional
    public void deleteAnime(Anime anime){
        animeRepo.delete(anime);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Anime> getAll(){
        return (ArrayList<Anime>) animeRepo.findAll();
    }
    
}
