package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.FeedBack;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends CrudRepository<FeedBack, Long> {
}
