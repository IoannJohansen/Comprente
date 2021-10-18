package com.sachishin.comprente.Repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.naming.Name;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Images")
public class Images {
    @Id
    @GeneratedValue
    private int Id;

    @NotNull
    private String path;

    @ManyToOne(optional = false)
    @JoinColumn(referencedColumnName = "id")
    private Technique technique;
}
