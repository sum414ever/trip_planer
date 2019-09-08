package edu.cursor.service;

import edu.cursor.entities.Trip;

import java.util.List;

public interface TripService {
    Trip addTrip(Long userId, Trip trip);

    void deleteTripById(Long id);

    Trip editTripById(Long id, Long tripId, Trip trip);

    Trip shareTripWithOtherUser(Long tripId, Long userId);

    Trip findTripById(Long id);

    List<Trip>  findAll();
}
