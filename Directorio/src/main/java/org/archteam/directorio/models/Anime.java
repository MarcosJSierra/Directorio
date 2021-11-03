/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.archteam.directorio.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 *
 * @author marcos
 */
@Entity
@Data
@Table(name="Anime")
public class Anime implements Serializable {
    @Id
    @Column(name = "idAnime")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name="no_seasons")
    private Integer noSeasons;
    
    @Column(name="no_episodes")
    private Integer noEpisodes;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "duration")
    private Double duration;
    
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "AnimeGenre",
            joinColumns = {@JoinColumn(name =  "idAnime", referencedColumnName = "idAnime")},
            inverseJoinColumns = { @JoinColumn(name = "idGenre", referencedColumnName = "id")}
    )
    Set<Genre> genres = new HashSet<>();
    
    
    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(
            name = "AnimeType",
            joinColumns = {@JoinColumn(name =  "idAnime", referencedColumnName = "idAnime")},
            inverseJoinColumns = { @JoinColumn(name = "idType", referencedColumnName = "id")}
    )
    Set<Type> types = new HashSet<>();
    
}
