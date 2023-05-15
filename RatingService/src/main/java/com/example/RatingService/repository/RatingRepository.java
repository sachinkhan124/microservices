package com.example.RatingService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RatingService.entity.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{
	
	public List<Rating> findByuserId(String userId);
	public List<Rating> findByhotelId(String hotelId);

}
