package com.example.HotelService.service;

import java.util.List;

import com.example.HotelService.entity.Hotel;

public interface HotelService {

	public Hotel createHotel(Hotel hotel);
	public Hotel getById(String hotelId);
	public List<Hotel>getAllHotel();
}
