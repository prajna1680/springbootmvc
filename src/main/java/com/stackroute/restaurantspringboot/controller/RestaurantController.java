package com.stackroute.restaurantspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.restaurantspringboot.entity.Restaurant;
import com.stackroute.restaurantspringboot.services.RestaurantService;


@Controller
public class RestaurantController {
	
	RestaurantService restaurantService;
	
	@Autowired
	public void setRestaurantService(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@RequestMapping(value = "/" , method = RequestMethod.GET)
	public String getIndexPage() {
		return "thymleaf/index";
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.GET)
	public String showRestaurantForm() {
		return "thymleaf/restaurantForm";
	}
	
	@PostMapping(value = "/addrestaurant")
	public String addRestaurant(Restaurant restaurant, @RequestParam("name")String name,@RequestParam("id")String id, @RequestParam("rating")int rating, @RequestParam("location")String location, @RequestParam("cuisine")String cuisine, Model model) throws Exception {
		model.addAttribute("name", name);
		model.addAttribute("id", id);
		model.addAttribute("rating", rating);
		model.addAttribute("location", location);
		model.addAttribute("cuisine", cuisine);
		restaurantService.addRestaurant(restaurant);
		return "thymleaf/success";
	}
	
	@RequestMapping(value = "/display" , method = RequestMethod.GET)
	public ModelAndView displayRestaurant() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("restaurantList", restaurantService.getAllRestaurants());
		modelAndView.setViewName("jsp/displayRestaurant");
		return modelAndView;
	}
	
	/*@RequestMapping(value = "{id}" , method = RequestMethod.GET)
	public void deleteRestaurant(@PathVariable("id")String id) {
		restaurantService.deleteRestaurant(id);
		System.out.println("controller");
		//return "thymleaf/delete";
		
	}*/
	
	@RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
   
	restaurantService.deleteRestaurant(id);;
    return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
	@RequestMapping(value = "/show" , method = RequestMethod.GET)
	public String showRestaurantById() {
		return "thymleaf/byId";
	}
	
	@RequestMapping(value = "/displayByID/{id}" , method = RequestMethod.GET)
	public ModelAndView findById(@RequestParam("id")String id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("restaurantList", restaurantService.getRestaurantById(id));
		modelAndView.setViewName("jsp/displayByID");
		System.out.println("by id controller");
		return modelAndView;
	}
	
	@RequestMapping(value = "/restaurantUpdate" , method = RequestMethod.GET)
	public String updateRestaurantById() {
		return "thymleaf/updateByID";
	}
	
	@RequestMapping(value = "/updateRestaurant/{id}", method = RequestMethod.GET)
	public ModelAndView update(Restaurant restaurant) {
		ModelAndView modelAndView = new ModelAndView();
		restaurantService.updateRestaurant(restaurant);
		modelAndView.addObject("restaurantUpdated");
		modelAndView.setViewName("jsp/displayUpdatedRestaurant");
		return modelAndView;
	}

}
