package com.sachishin.comprente.DTO;

import lombok.ToString;

import java.util.Date;

@ToString
public class BillRequest {
    public String itemName;

    public String UserName;

    public int rentCostPerDay;

    public int TotalDays;

    public int TotalCost;

    public long rentId;

    public long userId;

    public long techId;
}
