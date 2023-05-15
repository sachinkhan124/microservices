package com.example.HotelService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.HotelService.entity.Hotel;
import com.example.HotelService.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	@Autowired
	 private HotelService hotelService;
	@PostMapping("/addhotel")
	public ResponseEntity<Hotel>createHotel(@RequestBody Hotel hotel)
	{
		System.out.println(hotel);
		return new ResponseEntity<Hotel>(this.hotelService.createHotel(hotel),HttpStatus.OK);
	}
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel>getById(@PathVariable String hotelId)
	{
		return new ResponseEntity<Hotel>(this.hotelService.getById(hotelId),HttpStatus.OK);
	}
       @GetMapping("/")
	  public ResponseEntity<List<Hotel>>getAllHotel()
	  {
		  return new ResponseEntity<List<Hotel>>(this.hotelService.getAllHotel(),HttpStatus.OK);
	  }
}
