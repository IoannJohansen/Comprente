package com.sachishin.comprente.Repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Feedback")
public class FeedBack {
    @Id
    @GeneratedValue
    private int Id;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private User user;

    //TODO: ADD RANGE(1,5)
    @NotNull

    private int rating;

    private String message;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "Id")
    private Technique technique;
}
