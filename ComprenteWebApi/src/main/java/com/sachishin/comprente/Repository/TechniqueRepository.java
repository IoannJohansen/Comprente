package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.Technique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TechniqueRepository extends JpaRepository<Technique, Long> {
    Technique findByName(String name);

    Technique findById(long id);

    @Query(value = "select count(*) from Rents where RentStatus = 2 or RentStatus = 1 and TechniqueId = :TechId", nativeQuery = true)
    long checkForRentAvailability(@Param("TechId") long id);
}
