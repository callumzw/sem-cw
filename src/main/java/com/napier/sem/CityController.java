package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CityController
{
    @RequestMapping("CityWorld")
    public ArrayList<City> citiesWorld(){
        return City.citiesWorld();
    }

    /**
     * Get record of all Cities in X Continent.
     * @param continent of the City record to get.
     * @return The record of Cities.
     */
    @RequestMapping("CityCont")
    public ArrayList<City> citiesCont(@RequestParam(value="continent") String continent){
    return City.citiesCont(continent);
    }

    @RequestMapping("CityRegion")
    public ArrayList<City> citiesRegion(@RequestParam(value="Region") String Region){
        return City.citiesRegion(Region);
    }

    @RequestMapping("CityCountry")
    public ArrayList<City> citiesCountry(@RequestParam(value="Country") String Country){
        return City.citiesCountry(Country);
    }

    @RequestMapping("CityDistrict")
    public ArrayList<City> citiesDistrict(@RequestParam(value="District") String District){
        return City.citiesDistrict(District);
    }
}

