package com.stackroute.restaurantspringboot.dao;

import java.util.List;

import com.stackroute.restaurantspringboot.entity.Restaurant;

public interface RestaurantDao {

	
	Restaurant addRestaurant(Restaurant restaurant) throws Exception;
	List<Restaurant> getAllRestaurants();
	void deleteRestaurant(String id);
	Restaurant getRestaurantById(String id);
	void updateRestaurant(Restaurant restaurant);
}
