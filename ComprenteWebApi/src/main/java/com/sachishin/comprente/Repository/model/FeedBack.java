package com.sachishin.comprente.Repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Setter
@Getter
@Table(name = "Feedback")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "UserId", referencedColumnName = "Id")
    private User user;

    private String message;

    @JsonIgnore
    @ManyToOne(optional = false)
    @JoinColumn(name = "TechniqueId", referencedColumnName = "Id")
    private Technique technique;
}
