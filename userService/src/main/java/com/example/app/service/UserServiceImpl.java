package com.example.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.app.entity.Hotel;
import com.example.app.entity.Rating;
import com.example.app.entity.User;
import com.example.app.exception.ResourceNotFoundException;
import com.example.app.externalServices.HotelService;
import com.example.app.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private HotelService hotelService;

	@Override
	public User createUser(User user) {
		String randomuserId = UUID.randomUUID().toString();
		user.setUserId(randomuserId);
		return this.userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		// implement rating service call using rest template

		return this.userRepository.findAll();
	}

	@Override
	public User getById(String userId) {

		User user = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("userId not on server" + userId));
		// fetch rating of the above user from rating service
		Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/user/" + user.getUserId(),
				Rating[].class);
		logger.info("{}", ratingsOfUser);
		List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
		List<Rating> ratingList = ratings.stream().map(rating -> {
//			// http://localhost:8083/hotels/fe6e6a8f-9f15-4302-bb6f-0f4048889845
//			//System.out.println(rating.getHotelId());
			//ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
			//Hotel hotel = forEntity.getBody();
			Hotel hotel  =   hotelService.getHotel(rating.getHotelId());
			
			//logger.info("response Status code:{}", forEntity.getStatusCode());
			rating.setHotel(hotel);
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
	
		return user;
	}

}
