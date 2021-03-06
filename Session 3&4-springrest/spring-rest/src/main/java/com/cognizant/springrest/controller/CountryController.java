package com.cognizant.springrest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.xml.validation.Validator;
//import javax.validation.ConstraintViolation;
//import javax.validation.Valid;
//import javax.validation.Validation;
//import javax.validation.Validator;
//import javax.validation.ValidatorFactory;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.cognizant.springrest.Country;
import com.cognizant.springrest.service.CountryService;
import com.cognizant.springrest.service.exception.CountryNotFoundException;


@RestController
public class CountryController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	
	@Autowired
	CountryService service;
	
	@GetMapping("/country")
	public Country getCountryIndia(){
		
		LOGGER.info("Start");
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		Country country = (Country) context.getBean("in", Country.class);
		LOGGER.info("End");
		return country;
		
	}
	
	@GetMapping("/countries")
	public List<Country> getAllCountries(){
		LOGGER.info("Start");
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		List<Country> countries=context.getBean("countryList",java.util.ArrayList.class);
		LOGGER.info("End");
		return countries;
	}
	
	@GetMapping("country/{code}")
	public Country getCountryByCode(@PathVariable String code)throws CountryNotFoundException{
		LOGGER.info("Start");
		Country country=service.getCountry(code);
		LOGGER.info("End");
		return country;
	     }
	
	 @PostMapping("/countries")
	 public Country addCountry(@RequestBody @Valid  Country country) {
		
		LOGGER.info("Start...");
		//Create validator factory

		/*ValidatorFactory factory = Validator.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		// Validation is done against the annotations defined in country bean

		Set<ConstraintViolation<Country>> violations = validator.validate(country);
        List<String> errors = new ArrayList<String>();

		// Accumulate all errors in an ArrayList of type String

		for (ConstraintViolation<Country> violation : violations) {
        errors.add(violation.getMessage());
		}

		// Throw exception so that the user of this web service receives appropriate error message

		if (violations.size() > 0) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errors.toString());

		}*/
		
		LOGGER.info(country.toString());
		LOGGER.info("End..");
		return country;
	   }
	 
	    @PutMapping
		public Country updateCountry(@RequestBody Country country) throws CountryNotFoundException{
			LOGGER.info("Start");
			Country updated=service.updateCountry(country);
			LOGGER.info(updated.toString());
			LOGGER.info("End");
			return country;
		}
	 
	 
	
	
	
}
