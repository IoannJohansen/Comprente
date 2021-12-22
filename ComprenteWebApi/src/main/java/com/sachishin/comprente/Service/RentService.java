package com.sachishin.comprente.Service;

import com.sachishin.comprente.Repository.model.Rent;
import java.util.List;

public interface RentService {
    List<Rent> GetUserRentsPaged(long userId , int pageNum, int pageSize, int startStatusNumber, int endStatusNumber);
    List<Rent> GetActiveRentsPaged(int pageNum, int pageSize);
    int GetCountActiveRents();
    long GetCountForUserId(long userId);
    int AddRent(long userId, long techId);
    List<Rent> GetCompletedRents(int PageNum, int pageSize);
    int GetCountForRentStatus(int rentStatus);
    Rent GetRentById(long rentId);
    int RequestRent(long rentId);
    int GiveRent(long rentId);
    int CompleteRent(long rentId);
}
