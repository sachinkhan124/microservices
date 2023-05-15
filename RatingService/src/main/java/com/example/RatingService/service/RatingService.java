package com.example.RatingService.service;

import java.util.List;

import com.example.RatingService.entity.Rating;

public interface RatingService {
	
	public Rating createRating(Rating rating);
	public List<Rating>getAllRating();
	public List<Rating>getRatingByUser(String userId);
	public List<Rating>getRatingByHotel(String hotelId);

}
