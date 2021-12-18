package com.sachishin.comprente.Repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "RentList")
public class RentList {
    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private Technique technique;

    @NotNull
    private Date giveDate;

    @NotNull
    private Date FinishRentDate;

    @OneToOne
    @JoinColumn(referencedColumnName = "Id")
    private Bill bill;

    private int rentStatus;
}
