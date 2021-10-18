package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.Technique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechinqueRepository extends JpaRepository<Technique, Long> {
    Technique findByName(String name);
}
