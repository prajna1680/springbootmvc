package com.stackroute.restaurantspringboot.services;

import java.util.List;

import com.stackroute.restaurantspringboot.entity.Restaurant;

public interface RestaurantService {

	public Restaurant addRestaurant(Restaurant restaurant) throws Exception;
	public List<Restaurant> getAllRestaurants();
	//public void deleteRestaurant(int id);
	public boolean deleteRestaurant(String id);
	public Restaurant getRestaurantById(String id);
	public void updateRestaurant(Restaurant restaurant);

	
}

