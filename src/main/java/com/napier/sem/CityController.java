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

    @RequestMapping("TopCityDistrict")
    public ArrayList<City> TopcitiesDistrict(@RequestParam(value="District") String District, @RequestParam(value="limit") int limit){
        return City.TopcitiesDistrict(District, limit);
    }

    @RequestMapping("TopCityWorld")
    public ArrayList<City> TopcitiesWorld( @RequestParam(value="limit") int limit){
        return City.TopCityWorld(limit);
    }

    @RequestMapping("TopcitiesCont")
    public ArrayList<City> TopcitiesCont(@RequestParam(value="continent") String continent, @RequestParam(value="limit") int limit){
        return City.TopcitiesCont(continent, limit);
    }

    @RequestMapping("TopcitiesCountry")
    public ArrayList<City> TopcitiesCountry(@RequestParam(value="country") String country, @RequestParam(value="limit") int limit){
        return City.TopcitiesCountry(country, limit);
    }

    @RequestMapping("TopCityRegion")
    public ArrayList<City> TopcitiesRegion(@RequestParam(value="region") String region, @RequestParam(value="limit") int limit){
        return City.TopCityRegion(region, limit);
    }
}


