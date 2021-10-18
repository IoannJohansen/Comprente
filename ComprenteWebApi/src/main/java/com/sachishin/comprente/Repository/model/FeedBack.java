package com.sachishin.comprente.Repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Feedback")
public class FeedBack {
    @Id
    @GeneratedValue
    private long Id;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private User user;

    //TODO: ADD RANGE(1,5)
    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    private String message;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private Technique technique;
}
