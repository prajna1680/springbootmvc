package com.stackroute.restaurantspringboot.dao;


import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.stackroute.restaurantspringboot.entity.Restaurant;
import com.stackroute.restaurantspringboot.exceptions.DataBaseNotAvailableException;


@Transactional
@Repository
public class RestaurantDaoImpl implements RestaurantDao{

	@PersistenceContext    
    private EntityManager entityManager;
	
		
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) throws Exception{
		try {
			entityManager.persist(restaurant);
			return restaurant;
		}
		catch(Exception exception) {
			throw new DataBaseNotAvailableException("DataBase temporarily not available."); 
		}
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		String hql = "From Restaurant as rest ORDER BY rest.id";
		List<Restaurant> restaurantList = entityManager.createQuery(hql).getResultList();
		return restaurantList;
	}	

	@Override
	public void deleteRestaurant(String id) {
		String hql = "From Restaurant as rest ORDER BY rest.id";
		List<Restaurant> restaurantList = entityManager.createQuery(hql).getResultList();
		for(Restaurant res : restaurantList) {
			if(res.getId().equals(id)) {
				entityManager.remove(res);
			}
		}
		/*String hql = "Delete From Restaurant as rest where rest.id = ?" ;
		entityManager.createQuery(hql).setParameter(0, id).executeUpdate();
		System.out.println("dao");
	*/}

	@Override
	public Restaurant getRestaurantById(String id) {
		String hql = "From Restaurant as rest where rest.id = ?" ;
		Restaurant restaurantList = (Restaurant) entityManager.createQuery(hql).setParameter(0, id).getSingleResult();
		System.out.println("by" +id+ "dao");
		return restaurantList;
		
	}

	@Override
	public void updateRestaurant(Restaurant restaurant) {
        Query q = entityManager.createQuery("update Restaurant r set r.name = :name , r.rating = :rating, r.location = :location, r.cuisine = :cuisine where r.id = :id");
        q.setParameter("id", restaurant.getId());
        q.setParameter("name",restaurant.getName());
        q.setParameter("rating",restaurant.getRating());
        q.setParameter("location",restaurant.getLocation());
        q.setParameter("cuisine",restaurant.getCuisine());
        q.executeUpdate();
        System.out.println(restaurant.getName());
        System.out.println("done");
        //Restaurant updatedRestaurant = getRestaurantById(restaurant.setId(restaurant.getId()));
        //return updatedRestaurant;
        
	}
	

}
