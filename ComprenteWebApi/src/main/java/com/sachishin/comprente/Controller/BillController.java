package com.sachishin.comprente.Controller;

import com.sachishin.comprente.DTO.BillRequest;
import com.sachishin.comprente.DTO.PagedItemsResponse;
import com.sachishin.comprente.Repository.model.Bill;
import com.sachishin.comprente.Service.BillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/bill")
@CrossOrigin("**")
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

    @RequestMapping(value = "/getCommonBills", method = RequestMethod.GET)
    public PagedItemsResponse<?> GetAllBillsPaged(@RequestParam int pageNum, @RequestParam int pageSize){
        var userRentsPaged = new PagedItemsResponse<Bill>();
        userRentsPaged.Items = billService.GetCommonBills(pageNum, pageSize);
        userRentsPaged.TotalCount = billService.GetCommonCount();
        return userRentsPaged;
    }

    @RequestMapping(value = "/addBill", method = RequestMethod.POST)
    public ResponseEntity<?> GetUserBillsPaged(@RequestBody BillRequest billRequest){
        billService.AddBill(billRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
