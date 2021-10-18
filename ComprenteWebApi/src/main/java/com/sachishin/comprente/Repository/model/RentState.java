package com.sachishin.comprente.Repository.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "RentState")
public class RentState {
    @Id
    private long Id;
    @NotNull
    private String name;
    @NotNull
    private String description;
}
