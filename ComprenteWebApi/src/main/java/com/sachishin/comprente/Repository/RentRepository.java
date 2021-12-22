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

    List<Rent> findRentsByRentStatusGreaterThanAndRentStatusLessThan(int RentStatus, int endRentStatus, Pageable pageable);

    @Query(value = "select count(*) from Rents where RentStatus = 1 or RentStatus = 2", nativeQuery = true)
    int getCountForActiveRents();

    @Modifying
    @Query(value = "update Rents set RentStatus = 3, FinishDate = getdate() where Id = :rentId", nativeQuery = true)
    int setCompleteRentState(@Param("rentId") long rentId);

    @Modifying
    @Query(value = "update Rents set RentStatus = 2 where Id = :rentId", nativeQuery = true)
    int setInUsingRentState(@Param("rentId") long rentId);

    @Modifying
    @Query(value = "update Rents set RentStatus = 1 where Id = :rentId", nativeQuery = true)
    int setRequestRentState(@Param("rentId") long rentId);

    List<Rent> findRentsByRentStatus(int RentStatus, Pageable pageable);

    @Query(value = "select * from Rents where RentStatus = 3 and Rents.Id not in (select rent_id from Bill where Bill.rent_id = Rents.Id)", nativeQuery = true)
    List<Rent> getCompletedRents(Pageable pageable);

    int countAllByRentStatus(int RentStatus);

    Rent getRentById(long Id);
}
