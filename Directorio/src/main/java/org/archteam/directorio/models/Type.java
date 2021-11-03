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

@Table(name="Type")
public class Type implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    
    private String name;
    
    private String description;
    
    @ManyToMany(mappedBy = "types")
    private Set<Anime> animes = new HashSet<>();
}
