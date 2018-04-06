package com.stackroute.restaurantspringboot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.stackroute.restaurantspringboot.dao.RestaurantDao;
import com.stackroute.restaurantspringboot.entity.Restaurant;

@Service
@Primary
public class RestaurantServiceMySql implements RestaurantService{
	
	RestaurantDao restaurantDao;
	
	@Autowired
	public RestaurantServiceMySql(RestaurantDao restaurantDao) {
		super();
		this.restaurantDao = restaurantDao;
	}

	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws Exception {
		restaurantDao.addRestaurant(restaurant);
		return restaurant;
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		List<Restaurant> restaurantList = restaurantDao.getAllRestaurants();
		return restaurantList;
	}

	@Override
	public boolean deleteRestaurant(String id) {
		restaurantDao.deleteRestaurant(id);
		return true;
	}

	@Override
	public Restaurant getRestaurantById(String id) {
		Restaurant restaurant = restaurantDao.getRestaurantById(id);
		return restaurant;
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
		restaurant.setName(restaurant.getName());
		restaurant.setRating(restaurant.getRating());
		restaurant.setLocation(restaurant.getLocation());
		restaurant.setCuisine(restaurant.getCuisine());
		restaurantDao.updateRestaurant(restaurant);
		//return restaurant;
	}
}
