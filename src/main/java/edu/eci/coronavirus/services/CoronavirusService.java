package edu.eci.coronavirus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.coronavirus.http.HttpConnectApi;

@Service
public class CoronavirusService {
	@Autowired
	HttpConnectApi hca;
	
	public String getCountry(String country) {
		String virus = hca.getCountry(country);
		return virus;
	}
	
	public String getAllCountries() {
		String virus = hca.getAllCountries();
		return virus;
	}
}
