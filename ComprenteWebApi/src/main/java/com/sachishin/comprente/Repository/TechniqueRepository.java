package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.Technique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface TechniqueRepository extends JpaRepository<Technique, Long> {
    Technique findByName(String name);
    Technique findById(long id);
    @Query(value = "select count(*) from Rents where RentStatus = 2 or RentStatus = 1 and TechniqueId = :TechId", nativeQuery = true)
    long checkForRentAvailability(@Param("TechId") long id);

    @Modifying
    @Query(value = "update Technique set Name = :name, Description = :description, RentPrice = :rentCost where id = :id", nativeQuery = true)
    int updateTechnique(@Param("name") String name, @Param("description") String description, @Param("rentCost") long rentCost, @Param("id") long Id );
}