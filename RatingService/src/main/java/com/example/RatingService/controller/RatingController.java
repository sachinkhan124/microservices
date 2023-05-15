package com.example.RatingService.controller;

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

import com.example.RatingService.entity.Rating;
import com.example.RatingService.service.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	@Autowired
	private RatingService ratingService;
	
	@PostMapping("/add")
	public ResponseEntity<Rating>createRating(@RequestBody Rating rating)
	{
		return new ResponseEntity<Rating>(this.ratingService.createRating(rating),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Rating>>getAllRating()
	{
		return new ResponseEntity<List<Rating>>(this.ratingService.getAllRating(),HttpStatus.OK);
	}
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>>getRatingByUser(@PathVariable String userId)
	{
		return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByUser(userId),HttpStatus.OK);
	}
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>>getratingByHotel(@PathVariable String hotelId)
	{
		return new ResponseEntity<List<Rating>>(this.ratingService.getRatingByHotel(hotelId),HttpStatus.OK);
	}

}
