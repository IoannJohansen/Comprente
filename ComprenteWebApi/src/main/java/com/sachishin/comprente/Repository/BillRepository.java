package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.Bill;
import com.sachishin.comprente.Repository.model.Rent;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.List;

@Repository
@Transactional
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findAllByUserId(long UserId, Pageable pageable);
    @Query(value = "select count(*) from Bill where Bill.user_id = :userId", nativeQuery = true)
    int GetCount(@Param("userId") long userId);

    @Query(value = "select count(*) from Bill", nativeQuery = true)
    int GetCommonCount();

    @Modifying
    @Query(value = "insert into Bill(TotalCost, TotalDays, UserName, billingDate, itemName, rentCostPerDay, technique_id, user_id, rent_id) values (:totalCost, :totalDays, :userName, getdate() , :itemName, :rentCostPerDay, :techId, :userId, :rentId)", nativeQuery = true)
    void AddBill(@Param("totalCost") int totalCost, @Param("totalDays") int totalDays, @Param("userName") String userName, @Param("itemName") String itemName, @Param("rentCostPerDay") int rentCostPerDay, @Param("techId") long techId, @Param("userId") long userId, @Param("rentId") long rentId);
}
