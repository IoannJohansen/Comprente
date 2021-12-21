package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.Bill;
import com.sachishin.comprente.Repository.model.Rent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findAllByUserId(long UserId, Pageable pageable);
    @Query(value = "select count(*) from Bill where Bill.user_id = :userId", nativeQuery = true)
    int GetCount(@Param("userId") long userId);
}
