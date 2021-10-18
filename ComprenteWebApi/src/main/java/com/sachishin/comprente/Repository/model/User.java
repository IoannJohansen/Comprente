package com.sachishin.comprente.Repository.model;

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

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue
    private long Id;
    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    private String hashPassword;
    @NotNull
    @Email
    @Size(min=4, max=30)
    private String email;
}
