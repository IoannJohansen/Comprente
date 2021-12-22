package com.sachishin.comprente.Repository;
import com.sachishin.comprente.Repository.model.Images;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
@Transactional
public interface ImageRepository extends JpaRepository<Images, Long> {

    @Modifying
    @Query(value = "delete from Images where [TechniqueId] = :techId", nativeQuery = true)
    int deleteByTechniqueId(@Param("techId") long techId);

    @Modifying
    @Query(value = "insert into Images([TechniqueId], [path]) values (:techId, :path)", nativeQuery = true)
    int addImageToTech(@Param("path") String path, @Param("techId") long techId);


}
