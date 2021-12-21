package com.sachishin.comprente.Repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @NotNull
    @Column(columnDefinition="nvarchar(max)")
    private String path;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "TechniqueId", nullable = false, referencedColumnName = "Id")
    private Technique technique;
}
