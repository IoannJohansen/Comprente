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
@Table(name = "Bill")
public class Bill {
    @Id
    @GeneratedValue
    private int Id;

    @NotNull
    private int price;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private User user;

    @NotNull
    private Date billingDate;
}
