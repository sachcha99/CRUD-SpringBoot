package com.country.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.country.crud.model.Country;

public interface CrudRepo extends JpaRepository<Country,Integer>{

}
