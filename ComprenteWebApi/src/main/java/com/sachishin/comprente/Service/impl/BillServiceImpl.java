package com.sachishin.comprente.Service.impl;

import com.sachishin.comprente.DTO.PagedItemsResponse;
import com.sachishin.comprente.Repository.BillRepository;
import com.sachishin.comprente.Repository.model.Bill;
import com.sachishin.comprente.Service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository billRepository;

    @Override
    public List<Bill> GetUserBillsPaged(long userId, int pageNum, int pageSize ) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return billRepository.findAllByUserId(userId, pageable);
    }

    @Override
    public int GetCount(long userId) {
        return billRepository.GetCount(userId);
    }
}
