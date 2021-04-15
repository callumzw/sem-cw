package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController
{
    /**
     * Get record of all countries by population in X Continent.
     * @param continent of the Country record to get.
     * @return The record of the Countries in continent.
     */
    @RequestMapping("CountryCont")
    public ArrayList<Country> countriesCont(@RequestParam(value="continent") String continent){
        return Country.countriesCont(continent);
    }


    /**
     * Get record of all countries by population in X Continent.
     * @param continent of the Country record to get.
     * @return The record of the Countries in continent.
     */
    @RequestMapping("TopCountryCont")
    public ArrayList<Country> topCountryCont(@RequestParam(value = "num") int num, @RequestParam(value="num continent")  String continent){
        return Country.topCountryCont(num,continent);
    }

}
