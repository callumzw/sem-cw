package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PopulationController
{
    /**
     * Get record of the total,urban and rural populations of every Continent.
     * @return The record of Continent populations.
     */
    @RequestMapping("popCont")
    public ArrayList<Population> popContinent(){
        return Population.popContinent();
    }

    /**
     * Get record of the Worlds total,urban and rural populations.
     * @return The record of World population.
     */
    @RequestMapping("worldPop")
    public ArrayList<Population> worldPop(){
        return Population.worldPop();
    }

    /**
     * Get record of X Continent's total,urban and rural populations.
     * @param continent of the Population record to get.
     * @return The record of the populations in continent.
     */
    @RequestMapping("continentPop")
    public ArrayList<Population> continentPop(@RequestParam(value="continent") String continent){
        return Population.continentPop(continent);
    }

    /**
     * Get record of X Region's total,urban and rural populations.
     * @param region of the Population record to get.
     * @return The record of the populations in region.
     */
    @RequestMapping("regionPop")
    public ArrayList<Population> regionPop(@RequestParam(value="region") String region) {
        return Population.regionPop(region);
    }

    /**
     * Get record of X Country's total,urban and rural populations.
     * @param country of the Population record to get.
     * @return The record of the populations in country.
     */
    @RequestMapping("countryPop")
    public ArrayList<Population> countryPop(@RequestParam(value="country") String country) {
        return Population.regionPop(country);
    }

    /**
     * Get record of X District's total,urban and rural populations.
     * @param district of the Population record to get.
     * @return The record of the populations in district.
     */
    @RequestMapping("districtPop")
    public ArrayList<Population> districtPop(@RequestParam(value="district") String district) {
        return Population.regionPop(district);
    }

    /**
     * Get record of X City's total,urban and rural populations.
     * @param city of the Population record to get.
     * @return The record of the populations in city.
     */
    @RequestMapping("cityPop")
    public ArrayList<Population> cityPop(@RequestParam(value="region") String city) {
        return Population.regionPop(city);
    }

}
