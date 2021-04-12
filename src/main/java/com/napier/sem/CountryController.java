package com.napier.sem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class CountryController
{
    /**
     * Get a single employee record.
     * @param continent emp_no of the employee record to get.
     * @return The record of the employee with emp_no or null if no employee exists.
     */
    @RequestMapping("country")
    public ArrayList<Country> countriesCont(@RequestParam(value="continent") String continent){
        return Country.countriesCont(continent);
    }


}
