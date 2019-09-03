package edu.cursor.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToMany(mappedBy = "trips")
    private List<User> users = new ArrayList<>();

    @Column(name = "places")
    @ElementCollection(targetClass = Place.class)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "place_trip", joinColumns = @JoinColumn(name = "trip_id"), inverseJoinColumns = @JoinColumn(name = "place_id"))
    private List<Place> places = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public List<Place> getPlaces() {
        return places;
    }
}
