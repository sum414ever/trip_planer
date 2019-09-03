package edu.cursor.service;

import edu.cursor.entities.Place;
import edu.cursor.exceptions.DataNotFoundException;
import edu.cursor.repository.PlaceRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;

    @Override
    public Place addPlace(Place place) {
        return placeRepository.save(place);
    }

    @Override
    public void deletePlaceById(Long id) {
        placeRepository.deleteById(id);
    }

    @Override
    public Place findPlaceById(Long id) {
        return placeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("The place doesn't found"));
    }

    @Override
    public Place editPlaceById(Long id, Place place) {
        Place editedPlace = placeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("The place doesn't found"));

        editedPlace.setName(place.getName());
        editedPlace.setComments(place.getComments());
        editedPlace.setRates(place.getRates());

        return placeRepository.save(editedPlace);
    }
}
