package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
// This is a Test Class to test the methods in the Country Class
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
        country.code = "JPN";
        country.name = "Japan";
        country.continent = "Asia";
        country.region = "East Asia";
        country.population = 100000;
        country.capital = "Tokyo";
        countries.add(country);
        Country.displayCountry(countries);
    }
}
