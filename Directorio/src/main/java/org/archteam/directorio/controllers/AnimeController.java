/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.controllers;

import java.util.List;
import org.archteam.directorio.dtos.AnimeDto;
import org.archteam.directorio.models.Anime;
import org.archteam.directorio.repositories.AnimeRepository;
import org.archteam.directorio.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author marcos
 */
@RestController
//@CrossOrigin("http://localhost:8080")
@RequestMapping(value = "directory/anime")
public class AnimeController {
    
    @Autowired
    private AnimeService animeService;
    
    @GetMapping("/")
    List<Anime> getAnimeList(){
        return animeService.getAll();
    }
    
    @GetMapping("/genre/{id}")
    List<Anime> getAnimeByGenre(@PathVariable Long id){
        return animeService.getAnimesByGenre(id);
    }
    
    @GetMapping("/type/{id}")
    List<Anime> getAnimeByType(@PathVariable Long id){
        return animeService.getAnimesByType(id);
    }
    
    @GetMapping("/{id}")
    Anime getAnimeById(@PathVariable Long id){
        return animeService.getAnimeByID(id);
    }
    
    @PostMapping(value = "/")
    Anime createAnime(@RequestBody AnimeDto anime){
        return animeService.createAnime(anime);
    }
    
    @PutMapping("/{id}")
    Anime updateSensor(@RequestBody AnimeDto anime, @PathVariable Long id) {

        return animeService.updateAnime(anime, id);
    }
    
    @DeleteMapping("/{id}")
    void deleteAnime(@PathVariable Long id){
        animeService.deleteAnime(id);
    }
    
    
}
