/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import org.archteam.directorio.models.Type;
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
    
    @Override
    @Transactional(readOnly = true)
    public Type getTypeById(Long id){
        return typeRepo.findById(id).orElse(null);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Type> getTypesByAnime(Long id){
        return null;
    }
    
    @Override
    @Transactional
    public Type createType(Type type){
        return typeRepo.save(type);
    }
    
    @Override
    @Transactional
    public Type updateType(Type type){
        return typeRepo.save(type);
    }
    
    @Override
    @Transactional
    public void deleteType(Type type){
        typeRepo.delete(type);
    }
    
    @Override
    @Transactional(readOnly = true)
    public ArrayList<Type> getAll(){
        return (ArrayList<Type>) typeRepo.findAll();
    }
    
}
