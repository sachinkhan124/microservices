package com.example.app.Controller;

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

import com.example.app.entity.User;
import com.example.app.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;



@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/adduser")
	public ResponseEntity<?>createUser(@RequestBody User user)
	{
		return new ResponseEntity<>(this.userService.createUser(user),HttpStatus.OK);
	}
	@GetMapping("/{userId}")
	@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User>getByUser(@PathVariable String userId)
	{
		return new ResponseEntity<User>(this.userService.getById(userId),HttpStatus.OK);
	}
	//creating fall back method for circuitBreaker
	
	public ResponseEntity<User>ratingHotelFallback(String userId, Exception ex)
	{
		
		
		User user = User.builder().email("dummy@gmail.com").name("Dummy").about("This user is created dummy because some service is down").userId("141234").build();
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>>getAllUser()
	{
		return new ResponseEntity<List<User>>(this.userService.getAllUser(),HttpStatus.OK);
	}

}
