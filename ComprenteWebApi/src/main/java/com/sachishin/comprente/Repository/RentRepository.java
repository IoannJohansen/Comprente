package com.sachishin.comprente.Repository;

import com.sachishin.comprente.Repository.model.Rent;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public interface RentRepository extends JpaRepository<Rent, Long> {
    List<Rent> findAllByUserIdAndRentStatusGreaterThanAndRentStatusLessThan(long UserId, int RentStatus, int endRentStatus, Pageable pageable);
    List<Rent> findRentsByUserId(long userId);
    @Modifying
    @Query(value = "insert into Rents(ReceivingDate, RentStatus, techniqueId, UserId) values (getdate(), 1, :techId, :userId)", nativeQuery = true)
    int addRent(@Param("userId") long userId, @Param("techId") long techId);
}
