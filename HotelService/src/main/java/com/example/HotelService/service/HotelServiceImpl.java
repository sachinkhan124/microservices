package com.example.HotelService.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.HotelService.entity.Hotel;
import com.example.HotelService.exception.ResourceNotFoundException;
import com.example.HotelService.repository.HotelRepository;
@Service
public class HotelServiceImpl implements HotelService{
	@Autowired
	private HotelRepository hotelRepository;

	@Override
	public Hotel createHotel(Hotel hotel) {
		String hotelId=UUID.randomUUID().toString();
		hotel.setHotelId(hotelId);
		return this.hotelRepository.save(hotel);
	}

	@Override
	public Hotel getById(String hotelId) {
		
		return this.hotelRepository.findById(hotelId).orElseThrow(()-> new ResourceNotFoundException("HotelId Not Found"));
	}

	@Override
	public List<Hotel> getAllHotel() {
		
		return this.hotelRepository.findAll();
	}

}
