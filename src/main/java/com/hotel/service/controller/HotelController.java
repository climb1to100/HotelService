package com.hotel.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.service.entities.Hotel;
import com.hotel.service.services.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/list")
    public ResponseEntity<List<Hotel>> getAllHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @GetMapping("/byId")
    public ResponseEntity<Hotel> getHotelById(@RequestParam("hotelId") Long hotelId) {
        return ResponseEntity.ok(hotelService.getHotelById(hotelId));
    }

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel) {
        Hotel savedObject = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedObject);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteHotel(@RequestParam("hotelId") Long hotelId) {
        hotelService.removeHotelById(hotelId);
        return ResponseEntity.ok("Hotel with id :"+hotelId+" deleted successfully");
    }
}
