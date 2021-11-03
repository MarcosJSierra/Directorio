/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.dtos;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Data
public class TypeDto {
    private Long id;
    
    
    private String name;
    
    private String description;
    
    private Set<AnimeDto> animes = new HashSet<>();
}
