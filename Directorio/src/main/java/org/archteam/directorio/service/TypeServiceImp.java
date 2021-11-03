/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import java.util.Set;
import org.archteam.directorio.models.Anime;
import org.archteam.directorio.models.Type;
import org.archteam.directorio.repositories.AnimeRepository;
import org.archteam.directorio.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author marcos
 */
@Service
public class TypeServiceImp implements TypeService {
    
    @Autowired
    public TypeRepository typeRepo;
    @Autowired
    public AnimeRepository animeRepo;
    
    @Override
    @Transactional(readOnly = true)
    public Type getTypeById(Long id){
        return typeRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public Set<Type> getTypesByAnime(Long id){
        Anime anime = animeRepo.findById(id).orElse(null);
        if (anime == null){
            return null;
        }
        return anime.getTypes();
    }
    
    @Override
    @Transactional
    public Type createType(Type type){
        return typeRepo.save(type);
    }
    
    @Override
    @Transactional
    public Type updateType(Type newType, Long id){
        return typeRepo.findById(id)
                .map(type -> {
                    type.setDescription(newType.getDescription());
                    type.setName(newType.getName());
                    return typeRepo.save(type);
                }).orElseGet(() ->{ return newType;});
    }
    
    @Override
    @Transactional
    public void deleteType(Long id){
        Type type = typeRepo.getById(id);
        typeRepo.delete(type);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Type> getAll(){
        return (ArrayList<Type>) typeRepo.findAll();
    }
    
}
