package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.FeedBack;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Repository
@Transactional
public interface FeedBackRepository extends JpaRepository<FeedBack, Long> {
    List<FeedBack> findAllByTechniqueId(long TechniqueId, Pageable pageable);

    List<FeedBack> findFeedBacksByTechnique_Id(long techniqueId);

    @Modifying(clearAutomatically = true)
    @Query(value = "insert into Feedback([message], [TechniqueId], [UserId]) values (:message, :techId, :userId)", nativeQuery = true)
    void addFeedback(@Param("techId") long techId, @Param("userId") long userId, @Param("message") String message);
}
