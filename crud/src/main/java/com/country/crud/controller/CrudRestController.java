package com.country.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.country.crud.model.Country;
import com.country.crud.services.CrudService;

@RestController
public class CrudRestController {
	@Autowired
	private CrudService service;
	
	@GetMapping("/getcountrylist")
	@CrossOrigin(origins= "*")
	public List<Country> fetchCountryList(){
		
		List<Country> countries= new ArrayList<Country>();
		
		countries = service.fetchCountryList();
		return countries;
	}
	
	
	@PostMapping("/addcountry")
	@CrossOrigin(origins= "*")
	public Country saveCountry(@RequestBody Country country){
		
		return service.saveCountryToDB(country);
	}
	
	
	@GetMapping("/getcountrybyid/{id}")
	@CrossOrigin(origins= "*")
	public Country fetchCountryById(@PathVariable int id){
		
		return service.fetchCountryById(id).get();
	}
	
	@DeleteMapping("/deletecountrybyid/{id}")
	@CrossOrigin(origins= "*")
	public String deleteCountryById(@PathVariable int id){
		
		return service.deleteCountryById(id);
	}
	

}
