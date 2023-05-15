package com.example.app.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.app.entity.Rating;
@Service
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	@PostMapping("/rating/add")
	public ResponseEntity<Rating> createRating(Rating values);
	
	
	@PutMapping("/rating/{ratingId}")
	public Rating updateRating(@PathVariable String ratingId,Rating rating);
	
	@DeleteMapping("/rating/{ratingId}")
	public void deleteRating(@PathVariable String ratingId);
}
