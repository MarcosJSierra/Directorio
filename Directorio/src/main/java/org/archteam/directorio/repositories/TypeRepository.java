/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.archteam.directorio.repositories;

import java.util.ArrayList;
import org.archteam.directorio.models.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author marcos
 */
@Repository
public interface TypeRepository extends JpaRepository<Type, Long> {
    @Query(value = "SELECT idAnime FROM AnimeType WHERE idType = :idType", nativeQuery = true)
    ArrayList<Long> queryByTypeId(@Param("idType") Long idType);
}
