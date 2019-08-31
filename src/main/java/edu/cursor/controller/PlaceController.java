package edu.cursor.controller;

import edu.cursor.entities.Place;
import edu.cursor.service.PlaceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class PlaceController {
    private final PlaceService placeService;

    @PostMapping("/place")
    @ResponseBody
    public ResponseEntity addPlace(@RequestBody Place place){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.addPlace(place));
    }

    @DeleteMapping("/place/{id}")
    public ResponseEntity deletePlaceById(@PathVariable("id") Long id ){
        placeService.deletePlaceById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The place deleted");
    }

    @GetMapping("/place/{id}")
    public ResponseEntity<Place> findPlaceById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(placeService.findPlaceById(id));
    }

    @PutMapping("/place/{id}")
    @ResponseBody
    public ResponseEntity editPlaceById(@PathVariable("id") Long id, @RequestBody Place place){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("The place edited" + placeService.editPlaceById(id, place));
    }
}
