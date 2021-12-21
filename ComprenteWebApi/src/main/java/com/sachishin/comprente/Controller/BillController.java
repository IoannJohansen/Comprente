package com.sachishin.comprente.Controller;

import com.sachishin.comprente.DTO.PagedItemsResponse;
import com.sachishin.comprente.Repository.model.Bill;
import com.sachishin.comprente.Service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/bill")
@CrossOrigin("*")
public class BillController {
    @Autowired
    private BillService billService;

    @RequestMapping(value = "/getUserBills", method = RequestMethod.GET)
    public PagedItemsResponse<?> GetUserBillsPaged(@RequestParam long userId, @RequestParam int pageNum, @RequestParam int pageSize){
        var userRentsPaged = new PagedItemsResponse<Bill>();
        userRentsPaged.Items = billService.GetUserBillsPaged(userId, pageNum, pageSize);
        userRentsPaged.TotalCount = billService.GetCount(userId);
        return userRentsPaged;
    }

}
