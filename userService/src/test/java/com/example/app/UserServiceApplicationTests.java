package com.example.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;

import com.example.app.entity.Rating;
import com.example.app.externalServices.RatingService;


@SpringBootTest
public class UserServiceApplicationTests {

	@Test
    void contextLoads() {
    }

	private RatingService ratingService;
	
	
//	  @Test
//      void createRating() {
//      Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using feign client").build();
//      ResponseEntity<Rating> ratingResponseEntity = ratingService.createRating(rating);
//      System.out.println("new rating created");
//  }
}
