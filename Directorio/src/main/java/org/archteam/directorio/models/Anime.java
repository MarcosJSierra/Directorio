/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.archteam.directorio.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

/**
 *
 * @author marcos
 */
@Entity
@Data
@Table(name="Anime")
public class Anime implements Serializable {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    
    @Column(name="no_seasons")
    private Integer noSeasons;
    
    @Column(name="no_episodes")
    private Integer noEpisodes;
    
    private String description;
    
    private Double duration;
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "AnimeGenre",
            joinColumns = {@JoinColumn(name =  "idAnime")},
            inverseJoinColumns = { @JoinColumn(name = "idGenre")}
    )
    Set<Genre> genres = new HashSet<>();
    
    
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "AnimeType",
            joinColumns = {@JoinColumn(name =  "idAnime")},
            inverseJoinColumns = { @JoinColumn(name = "idType")}
    )
    Set<Type> types = new HashSet<>();
}
