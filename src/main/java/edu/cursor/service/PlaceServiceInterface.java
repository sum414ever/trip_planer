package edu.cursor.service;

import edu.cursor.entities.Place;

public interface PlaceServiceInterface {
    Place addPlace(Place place);

    void deletePlaceById(Long id);

    Place findPlaceById(Long id);

    Place editPlaceById(Long id, Place place);
}
