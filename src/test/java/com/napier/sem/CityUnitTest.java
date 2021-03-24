package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

// This is a Test Class to test the methods in the City Class
public class CityUnitTest
{
    static City city;

    @BeforeAll
    static void init()
    {
        city = new City();
    }

    @Test
    void printCityTestNull()
    {
        city.displayCity(null);
    }

    @Test
    void printCityTestEmpty()
    {
        ArrayList<City> city = new ArrayList<City>();
        City.displayCity(city);
    }
    @Test
    void printCountriesTestContainsNull()
    {
        ArrayList<City> city = new ArrayList<City>();
        city.add(null);
        City.displayCity(city);
    }
    @Test
    void printCountries()
    {
        ArrayList<City> cities = new ArrayList<City>();
        City city = new City();
        city.setName("Kabul");
        city.setCountry("AFG");
        city.setDistrict("Kabol");
        city.setPopulation(1780000);
        cities.add(city);
        City.displayCity(cities);
    }

}
