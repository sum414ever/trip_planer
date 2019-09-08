package edu.cursor.controller;

import edu.cursor.entities.Trip;
import edu.cursor.service.TripServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class TripController {
    private final TripServiceImpl tripService;

    @PostMapping("/{id}/trip")
    @ResponseBody
    public ResponseEntity addTrip(@PathVariable("id") Long id, @RequestBody Trip trip) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripService.addTrip(id, trip));
    }

    @DeleteMapping("/trip/{id}")
    public ResponseEntity deleteTripById(@PathVariable("id") Long id) {
        tripService.deleteTripById(id);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("Trip by id " + id + " deleted successfully");
    }

    @PutMapping("/{userId}/trip/{tripId}")
    @ResponseBody
    public ResponseEntity editTripById(@PathVariable("userId") Long userId, @PathVariable("tripId") Long tripId, @RequestBody Trip trip) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripService.editTripById(userId, tripId, trip));
    }

    @PatchMapping("/{userId}/trip/{tripId}")
    public ResponseEntity shareTripWhitOtherUser(@PathVariable("userId") Long userId, @PathVariable("tripId") Long tripId){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripService.shareTripWithOtherUser(tripId,userId));
    }

    @GetMapping("/trip/{id}")
    public ResponseEntity<Trip> findTripById(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripService.findTripById(id));
    }

    @GetMapping("/trip")
    public ResponseEntity showAllTrip(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(tripService.findAll());
    }
}
