package com.cognizant.springrest.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.cognizant.springrest.Country;
import com.cognizant.springrest.service.exception.CountryNotFoundException;


@Service
public class CountryService {
	
	public Country getCountry(String code) throws CountryNotFoundException{
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries= context.getBean("countryList",java.util.ArrayList.class);
		for(Country c : countries) {
			if(c.getCode().equalsIgnoreCase(code)) {
				return c;
			}
		}
		throw new CountryNotFoundException();
		
	}

	public Country updateCountry(Country country) throws CountryNotFoundException{
		// TODO Auto-generated method stub
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		Country before=null;
		try{
			before=context.getBean(country.getCode().toLowerCase(),com.cognizant.springrest.Country.class);
		}catch (Exception e) {
			// TODO: handle exception
			throw new CountryNotFoundException();
		}	
		before.setName(country.getName());
		return before;
		
		}
		
	

}
