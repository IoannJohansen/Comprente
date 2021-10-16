package com.sachishin.comprente.Repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int Id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id")
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "Id")
    private Technique technique;

    @NotNull
    private Date giveDate;

    @NotNull
    private Date FinishiRentDate;

    @OneToOne
    @JoinColumn("Id")
    private Bill bill;

    @ManyToOne
    @JoinColumn(name = "Id")
    private RentState rentState;
}
