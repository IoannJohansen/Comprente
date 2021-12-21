package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.Repository.RentRepository;
import com.sachishin.comprente.Repository.model.Rent;
import com.sachishin.comprente.Service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public long GetCountForUserId(long userId) {
        return rentRepository.findRentsByUserId(userId).size();
    }

    @Override
    public int AddRent(long userId, long techId) {
        return rentRepository.addRent(userId, techId);
    }
}
