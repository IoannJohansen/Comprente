package com.sachishin.comprente.Repository.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.jmx.export.annotation.ManagedAttribute;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Admin")
public class Admin {
    @Id
    @GeneratedValue
    private long Id;
    @NotNull
    private String email;
    @NotNull
    private String hashPassword;
}
