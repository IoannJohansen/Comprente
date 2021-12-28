package com.sachishin.comprente.Repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private long id;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "UserId")
    private User user;

    @JsonManagedReference
    @ManyToOne(optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "techniqueId")
    private Technique technique;

    @NotNull
    @Column(name = "ReceivingDate")
    private Date giveDate;

    @NotNull
    @Column(name = "finishDate")
    private Date finishRentDate;

    @Column(name = "RentStatus")
    private int rentStatus;
}
