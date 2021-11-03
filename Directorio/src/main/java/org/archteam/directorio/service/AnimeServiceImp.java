/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.archteam.directorio.dtos.AnimeDto;
import org.archteam.directorio.dtos.GenreDto;
import org.archteam.directorio.models.Anime;
import org.archteam.directorio.models.Genre;
import org.archteam.directorio.models.Type;
import org.archteam.directorio.repositories.AnimeRepository;
import org.archteam.directorio.repositories.GenreRepository;
import org.archteam.directorio.repositories.TypeRepository;
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
    
    @Autowired
    public GenreRepository genreRepo;
    
    @Autowired
    public TypeRepository typeRepo;
    
    @Override
    @Transactional(readOnly = true)
    public Anime getAnimeByID(Long id){
        return animeRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Anime> getAnimesByGenre(Long id){
        ArrayList<Long> tmp = genreRepo.queryByAnimeId(id);
        ArrayList<Anime> animes = new ArrayList<>();
        for(Long idAnime : tmp){
            animes.add(animeRepo.findById(idAnime).get());
        }
        return animes;
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Anime> getAnimesByType(Long id){
        ArrayList<Long> tmp = typeRepo.queryByTypeId(id);
        ArrayList<Anime> animes = new ArrayList<>();
        for(Long idAnime : tmp){
            animes.add(animeRepo.findById(idAnime).get());
        }
        return animes;
    }
    
    @Override
    @Transactional
    public Anime createAnime(AnimeDto anime){
        Anime animeNew = new Anime();
        animeNew.setDescription(anime.getDescription());
        animeNew.setDuration(anime.getDuration());
        Set<Genre> genres = new HashSet<>();
        for(Long genre : anime.getGenres()){
            Genre gtemp = genreRepo.findById(genre).orElse(null);
            if(gtemp != null){
                genres.add(gtemp);
            }
        }
        animeNew.setGenres(genres);
        animeNew.setName(anime.getName());
        animeNew.setNoEpisodes(anime.getNoEpisodes());
        animeNew.setNoSeasons(anime.getNoSeasons());
        Set<Type> types = new HashSet<>();
        anime.getTypes().forEach(typeDto -> {
            types.add(typeRepo.findById(typeDto).get());
        });
        animeNew.setTypes(types);
        return animeRepo.save(animeNew);
    }
    
    @Override
    @Transactional
    public Anime updateAnime(AnimeDto newAnime, Long id){
        Set<Genre> genres = new HashSet<>();
        newAnime.getGenres().forEach(genreDto -> {
            genres.add(genreRepo.findById(genreDto).get());
        });
        Set<Type> types = new HashSet<>();
        newAnime.getTypes().forEach(typeDto -> {
            types.add(typeRepo.findById(typeDto).get());
        });
        
        return animeRepo.findById(id)
                .map(anime -> {
                    anime.setDescription(newAnime.getDescription());
                    anime.setName(newAnime.getName());
                    anime.setDuration(newAnime.getDuration());
                    anime.setGenres(genres);
                    anime.setNoEpisodes(newAnime.getNoEpisodes());
                    anime.setNoSeasons(newAnime.getNoSeasons());
                    anime.setTypes(types);
                    return animeRepo.save(anime);
                }).orElseGet(() ->{ return null;});
    }
    
    @Override
    @Transactional
    public void deleteAnime(Long id){
        Anime anime = animeRepo.findById(id).get();
        animeRepo.delete(anime);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Anime> getAll(){
        return (ArrayList<Anime>) animeRepo.findAll();
    }
    
}
