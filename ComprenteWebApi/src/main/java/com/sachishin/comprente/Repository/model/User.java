package com.sachishin.comprente.Repository.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Email
    @Size(min=4, max=30)
    private String email;

    @JsonBackReference
    @OneToMany(mappedBy="user")
    private Set<Rent> rents;

    @NotNull
    private String role;

    @NotNull
    @Size(min=5, max=30)
    private String username;

    @NotNull
    @JsonIgnore
    private String hashPassword;
}
