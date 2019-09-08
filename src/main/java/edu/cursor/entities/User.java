package edu.cursor.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Email
    @Column(name = "email", unique = true)
    private String email;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_trip", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "trip_id"))
    private List<Trip> trips = new ArrayList<>();
}
