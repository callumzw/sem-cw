package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CityController
{
    /**
     * Get record of all Cities in X Continent.
     * @param continent of the City record to get.
     * @return The record of Cities.
     */
    @RequestMapping("CityCont")
    public ArrayList<City> citiesCont(@RequestParam(value="continent") String continent){
        return City.citiesCont(continent);
    }

}

