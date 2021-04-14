package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PopulationController
{
    /**
     * Get record of Continents total,urban and rural populations.
     * @return The record of Continent populations.
     */
    @RequestMapping("popCont")
    public ArrayList<Population> popContinent(){
        return Population.popContinent();
    }

}
