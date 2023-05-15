package com.example.RatingService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.RatingService.entity.Rating;
import com.example.RatingService.repository.RatingRepository;
@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	private RatingRepository ratingRepository;

	@Override
	public Rating createRating(Rating rating) {
		String ratingId=UUID.randomUUID().toString();
		rating.setRatingId(ratingId);
		return this.ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		
		return this.ratingRepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUser(String userId) {
		
		return this.ratingRepository.findByuserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotel(String hotelId) {
		
		return this.ratingRepository.findByhotelId(hotelId);
	}

}
