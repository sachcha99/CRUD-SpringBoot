package com.country.crud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.country.crud.model.Country;
import com.country.crud.repo.CrudRepo;

@Service
public class CrudService {
	@Autowired
	private CrudRepo repo;
	
	public List<Country> fetchCountryList(){
		return repo.findAll();
		
	}
	
	public Country saveCountryToDB(Country country)
	{
		return repo.save(country);
	}
	
	public Optional<Country> fetchCountryById(int id)
	{
		return repo.findById(id);
	}
	
	public String deleteCountryById(int id)
	{
		String result;
		try {
			repo.deleteById(id);
		 	result= "Country succesfully deleted";
		}
		catch (Exception e) {
			result= "Country with id is not  deleted";
			
		}
		return result;
	}
}
