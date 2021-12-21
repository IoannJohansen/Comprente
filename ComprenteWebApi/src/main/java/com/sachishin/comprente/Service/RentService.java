package com.sachishin.comprente.Service;

import com.sachishin.comprente.Repository.model.Rent;

import java.util.ArrayList;
import java.util.List;

public interface RentService {
    List<Rent> GetUserRentsPaged(long userId , int pageNum, int pageSize, int startStatusNumber, int endStatusNumber);
    long GetCountForUserId(long userId);
    int AddRent(long userId, long techId);
}
