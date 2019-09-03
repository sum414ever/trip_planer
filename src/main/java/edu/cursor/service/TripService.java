package edu.cursor.service;

import edu.cursor.entities.Trip;
import edu.cursor.entities.User;

public interface TripService {
    Trip addTrip(Long userId, Trip trip);

    void deleteTripById(Long id);

    void editTripById(Long id,Long tripId, Trip trip);

    void shareTripWithOtherUser(Long tripId, Long userId);

    Trip findTripById(Long id);
}
