package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.RentList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentRepository extends CrudRepository<RentList, Long> {
}
