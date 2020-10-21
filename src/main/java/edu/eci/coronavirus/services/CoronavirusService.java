package edu.eci.coronavirus.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.coronavirus.cache.CacheConfiguration;
import edu.eci.coronavirus.http.HttpConnectApi;

@Service
public class CoronavirusService {
	@Autowired
	HttpConnectApi hca;
	
	@Autowired
	CacheConfiguration cc;
	
	public String getCountry(String country) {
		String virus;
		if(cc.cacheCountry(country)) {
			virus = cc.getCache(country);
			System.out.println("-------uso--cache------");
		} else {
			virus = hca.getCountry(country);
			cc.saveCache(country, virus);
			System.out.println("-------guardo-cache-------");
		}
		return virus;
	}
	
	public String getAllCountries() {
		String virus = hca.getAllCountries();
		return virus;
	}
	
	public String getUbication(String country) {
		String ubication = hca.getUbication(country);
		return ubication;
	}
}
