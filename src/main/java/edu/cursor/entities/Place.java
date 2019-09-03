package edu.cursor.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "places")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "comments")
    @ElementCollection(targetClass = String.class)
    private List<String> comments;

    @Column(name = "rates")
    @ElementCollection(targetClass = Double.class)
    private List<Double> rates;

    @ManyToOne
    @JoinColumn(name="trip_id")
    private Trip trip;
}
