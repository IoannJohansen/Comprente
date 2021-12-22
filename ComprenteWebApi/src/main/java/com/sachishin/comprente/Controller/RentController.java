package com.sachishin.comprente.Controller;

import com.sachishin.comprente.DTO.PagedItemsResponse;
import com.sachishin.comprente.Repository.model.Rent;
import com.sachishin.comprente.Service.RentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @RequestMapping(value = "/getUserRentsPaged", method = RequestMethod.GET)
    public PagedItemsResponse<?> GetUserRentsPaged(@RequestParam long userId, @RequestParam int pageNum, @RequestParam int pageSize){
        var userRentsPaged = new PagedItemsResponse<Rent>();
        userRentsPaged.TotalCount = rentService.GetCountForUserId(userId);
        userRentsPaged.Items = rentService.GetUserRentsPaged(userId, pageNum, pageSize, 0, 3);
        return userRentsPaged;
    }

    @RequestMapping(value = "/getUserRentsHistoryPaged", method = RequestMethod.GET)
    public PagedItemsResponse<?> GetUserRentHistoryPaged(@RequestParam long userId, @RequestParam int pageNum, @RequestParam int pageSize){
        var userRentsPaged = new PagedItemsResponse<Rent>();
        userRentsPaged.TotalCount = rentService.GetCountForUserId(userId);
        userRentsPaged.Items = rentService.GetUserRentsPaged(userId, pageNum, pageSize, 2, 4);
        return userRentsPaged;
    }

    @RequestMapping(value = "/requestRent", method = RequestMethod.GET)
    public ResponseEntity<?> RequestRent(@RequestParam long UserId, @RequestParam int TechId){
        int rowsAffected = rentService.AddRent(UserId, TechId);
        return rowsAffected==1?new ResponseEntity<>(HttpStatus.OK):new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/getActiveRentsPaged", method = RequestMethod.GET)
    public PagedItemsResponse<?> GetActiveRents(@RequestParam int pageNum, @RequestParam int pageSize){
        var userRentsPaged = new PagedItemsResponse<Rent>();
        userRentsPaged.TotalCount = rentService.GetCountActiveRents();
        userRentsPaged.Items = rentService.GetActiveRentsPaged(pageNum, pageSize);
        return userRentsPaged;
    }

    @RequestMapping(value = "/changeRentStatus", method = RequestMethod.GET)
    public ResponseEntity<?> ChangeRentStatus(@RequestParam long rentId, @RequestParam int newStatus){
        switch (newStatus){
            case 1:
                rentService.RequestRent(rentId);
                break;
            case 2:
                rentService.GiveRent(rentId);
                break;
            case 3:
                rentService.CompleteRent(rentId);
                break;
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getCompletedRents", method = RequestMethod.GET)
    public PagedItemsResponse<?> GetCompletedRents(@RequestParam int pageNum, @RequestParam int pageSize){
        var userRentsPaged = new PagedItemsResponse<Rent>();
        userRentsPaged.TotalCount = rentService.GetCountForRentStatus(3);
        userRentsPaged.Items = rentService.GetCompletedRents(pageNum, pageSize);
        return userRentsPaged;
    }

    @RequestMapping(value = "/getRentById", method = RequestMethod.GET)
    public ResponseEntity<?> GetRentById(@RequestParam long rentId){
        var rent = rentService.GetRentById(rentId);
        return new ResponseEntity<>(rent, HttpStatus.OK);
    }
}