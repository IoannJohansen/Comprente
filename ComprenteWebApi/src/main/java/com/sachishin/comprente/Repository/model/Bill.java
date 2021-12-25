package com.sachishin.comprente.Repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    private String itemName;

    @NotNull
    private String UserName;

    @NotNull
    private long rentCostPerDay;

    @NotNull
    private long TotalDays;

    @NotNull
    private long TotalCost;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id", name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Id", name = "technique_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Technique technique;

    @ManyToOne
    @JoinColumn(referencedColumnName = "Id", name = "rent_id")
    private Rent rent;


    @NotNull
    private Date billingDate;
}
