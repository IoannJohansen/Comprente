package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.Repository.RentRepository;
import com.sachishin.comprente.Repository.model.Rent;
import com.sachishin.comprente.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentServiceImpl implements RentService {

    @Autowired
    private RentRepository rentRepository;

    @Override
    public List<Rent> GetUserRentsPaged(long userId, int pageNum, int pageSize, int startStatusNumber, int endStatusNumber) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var userRents = rentRepository.findAllByUserIdAndRentStatusGreaterThanAndRentStatusLessThan(userId, startStatusNumber, endStatusNumber, pageable);
        return userRents;
    }

    @Override
    public List<Rent> GetActiveRentsPaged(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        var items = rentRepository.findRentsByRentStatusGreaterThanAndRentStatusLessThan(0, 3, pageable);
        return items;
    }

    @Override
    public int GetCountActiveRents() {
        return rentRepository.getCountForActiveRents();
    }

    @Override
    public long GetCountForUserId(long userId) {
        return rentRepository.findRentsByUserId(userId).size();
    }

    @Override
    public int AddRent(long userId, long techId) {
        return rentRepository.addRent(userId, techId);
    }

    @Override
    public List<Rent> GetCompletedRents(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize, Sort.by("FinishDate").descending());
        return rentRepository.getCompletedRents(pageable);
    }

    @Override
    public int GetCountForRentStatus(int rentStatus) {
        return rentRepository.countAllByRentStatus(rentStatus);
    }

    @Override
    public Rent GetRentById(long rentId) {
        return rentRepository.getRentById(rentId);
    }

    @Override
    public int RequestRent(long rentId) {
        return rentRepository.setRequestRentState(rentId);
    }

    @Override
    public int GiveRent(long rentId) {
        return  rentRepository.setInUsingRentState(rentId);
    }

    @Override
    public int CompleteRent(long rentId) {
        return rentRepository.setCompleteRentState(rentId);
    }
}
