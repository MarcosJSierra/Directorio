/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.repositories;

import org.archteam.directorio.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author marcos
 */
interface TypeRepository extends JpaRepository<Type, Long> {
    
}