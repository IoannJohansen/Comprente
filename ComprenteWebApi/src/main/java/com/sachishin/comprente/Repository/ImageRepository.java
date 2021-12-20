package com.sachishin.comprente.Repository;
import com.sachishin.comprente.Repository.model.Images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ImageRepository extends JpaRepository<Images, Long> {

    @Modifying
    @Query(value = "delete from Images where TechniqueId = :techId;", nativeQuery = true)
    void deleteByTechniqueId(@Param("techId") long techId);


    @Query(value = "insert into Images([TechniqueId], [path]) values (:techId, :path);", nativeQuery = true)
    void addImageToTech(@Param("path") String path, @Param("techId") long techId);


}
