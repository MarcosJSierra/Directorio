/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.dtos;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import org.archteam.directorio.models.Type;

/**
 *
 * @author marcos
 */
@Data
public class AnimeDto {
    private Long id;
    
    private String name;
    
    private Integer noSeasons;
    
    private Integer noEpisodes;
    
    private String description;
    
    private Double duration;
    
    Set<GenreDto> genres = new HashSet<>();
    
    Set<TypeDto> types = new HashSet<>();
}
