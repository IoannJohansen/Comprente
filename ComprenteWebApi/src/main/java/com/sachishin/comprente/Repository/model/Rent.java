package com.sachishin.comprente.Repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@Table(name = "Rents")
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "UserId")
    private User user;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "techniqueId")
    private Technique technique;

    @NotNull
    @Column(name = "ReceivingDate")
    private Date giveDate;

    @NotNull
    @Column(name = "FinishDate")
    private Date FinishRentDate;

    @Column(name = "RentStatus")
    private int rentStatus;
}
