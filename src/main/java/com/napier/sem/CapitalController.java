package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CapitalController
{
    @RequestMapping("capitalsWorld")
    public ArrayList<Capital> capitalsWorld(){
        return Capital.capitalsWorld();
    }

    /**
     * Get record of all Capitals in X Continent.
     * @param continent of the Capital record to get.
     * @return The record of Capitals.
     */
    @RequestMapping("CapitalCont")
    public ArrayList<Capital> citiesCont(@RequestParam(value="continent") String continent){
        return Capital.capitalsCont(continent);
    }

    @RequestMapping("capitalsRegion")
    public ArrayList<Capital> capitalsRegion(@RequestParam(value="Region") String Region){
        return Capital.capitalsRegion(Region);
    }
}
