/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.controllers;

import java.util.List;
import java.util.Set;
import org.archteam.directorio.models.Genre;
import org.archteam.directorio.service.GenreService;
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
@RequestMapping(value = "directory/genre")
public class GenreController {
    
    @Autowired
    private GenreService genreService;
    
    @GetMapping("/")
    List<Genre> getGenreList(){
        return genreService.getAll();
    }
    
    @GetMapping("/anime/{id}")
    Set<Genre> getGenreByAnime(@PathVariable Long id){
        return genreService.getGenreByAnime(id);
    }
    
    @GetMapping("/{id}")
    Genre getGenreById(@PathVariable Long id){
        return genreService.getGenreById(id);
    }
    
    @PostMapping(value = "/")
    Genre createAnime(@RequestBody Genre genre){
        return genreService.createGenre(genre);
    }
    
    @PutMapping("/{id}")
    Genre updateSensor(@RequestBody Genre genre, @PathVariable Long id) {

        return genreService.updateGenre(genre, id);
    }
    
    @DeleteMapping("/{id}")
    void deleteAnime(@PathVariable Long id){
        genreService.deleteGenre(id);
    }
}
