/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.service;

import java.util.ArrayList;
import org.archteam.directorio.models.Type;

/**
 *
 * @author marcos
 */
public interface TypeService {
    
    public Type getTypeById(Long id);
    
    public ArrayList<Type> getTypesByAnime(Long id);
    
    public Type createType(Type type);
    
    public Type updateType(Type type);
    
    public void deleteType(Type type);
    
    public ArrayList<Type> getAll();
    
}
