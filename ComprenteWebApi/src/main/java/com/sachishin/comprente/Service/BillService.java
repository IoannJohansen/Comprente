package com.sachishin.comprente.Service;


import com.sachishin.comprente.Repository.model.Bill;

import java.awt.print.Pageable;
import java.util.List;

public interface BillService {
    List<Bill> GetUserBillsPaged(long userId, int pageNum, int pageSize);
    int GetCount(long userId);
}
