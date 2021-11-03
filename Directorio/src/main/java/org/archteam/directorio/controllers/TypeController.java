/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.controllers;

import java.util.List;
import org.archteam.directorio.models.Type;
import org.archteam.directorio.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping(value = "directory/type")
public class TypeController {
    
    @Autowired
    private TypeService typeService;
    
    @GetMapping("/")
    List<Type> getAnimeList(){
        return typeService.getAll();
    }
    
    @GetMapping("/anime/{id}")
    List<Type> getTypeByAnime(@PathVariable Long id){
        return typeService.getTypesByAnime(id);
    }
    
    @GetMapping("/{id}")
    Type getTypeById(@PathVariable Long id){
        return typeService.getTypeById(id);
    }
    
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    Type createAnime(Type type){
        return typeService.createType(type);
    }
    
    @PutMapping("/{id}")
    Type updateSensor(@RequestBody Type type, @PathVariable Integer id) {

        return typeService.updateType(type);
    }
    
    @DeleteMapping("/{id}")
    void deleteAnime(@PathVariable Long id){
        typeService.deleteType(id);
    }
}
