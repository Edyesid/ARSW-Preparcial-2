package edu.eci.coronavirus.controllers;

import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import edu.eci.coronavirus.http.HttpConnectApi;
import edu.eci.coronavirus.services.CoronavirusService;


@Controller
@RequestMapping(value = "/countries")
public class CoronavirusController {
    @Autowired
    CoronavirusService crs;
   
    
    @GetMapping(value="/{country}")
    public ResponseEntity<?> getCountry(@PathVariable("country") String country) {
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Content-Type", "application/json");
    	try {
    		
    		String data = crs.getCountry(country);
			return new ResponseEntity<>(data,headers,HttpStatus.ACCEPTED);
    		
    	} catch (Exception e) {
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
    	}
    }
    
    @GetMapping()
    public ResponseEntity<?> getAllCountries() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.set("Content-Type", "application/json");
    	try {
    		
    		String data = crs.getAllCountries();
			return new ResponseEntity<>(data,headers,HttpStatus.ACCEPTED);
    		
    	} catch (Exception e) {
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
    	}
    }
    
}
