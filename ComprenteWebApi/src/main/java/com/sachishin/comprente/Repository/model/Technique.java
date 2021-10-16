package com.sachishin.comprente.Repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "Technique")
public class Technique {
    @Id
    @GeneratedValue
    private int Id;
    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private Date datePublish;
    @NotNull
    private int rentPrice;

    @OneToMany(mappedBy = "Id", fetch = FetchType.LAZY)
    private Collection<Images> images;
}
