package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
/**
 * This class creates unit tests for the Country, City and Capital classes
 * Testing their methods validity.
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-03-19
 */
public class AppTest
{
    static Country country;

    @BeforeAll
    static void init()
    {
        country = new Country();
    }

    @Test
    void printCountriesTestNull()
    {
        country.displayCountry(null);
    }
    @Test
    void printCountriesTestEmpty()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country.displayCountry(countries);
    }
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        Country.displayCountry(countries);
    }
    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country country = new Country();
        country.setCode("JPN");
        country.setName("Japan");
        country.setContinent("Asia");
        country.setRegion("East Asia");
        country.setPopulation(100000);
        country.setCapital("Tokyo");
        countries.add(country);
        Country.displayCountry(countries);
    }
}
