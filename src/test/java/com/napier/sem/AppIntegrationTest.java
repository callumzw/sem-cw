package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationTest
{
// Country Class Tests
    @BeforeAll
    static void init()
    {
        Connection.connect("localhost:33060");
    }

    @Test
    void testCountriesWorld()
    {
        ArrayList<Country> countries = Country.countriesWorld();
        assertEquals(countries.get(0).code, "CHN");
        assertEquals(countries.get(0).name, "China");
        assertEquals(countries.get(0).continent, "Asia");
    }
    @Test
    void testCountriesCont()
    {
        ArrayList<Country> countries = Country.countriesCont("Europe");
        assertEquals(countries.get(0).code, "RUS");
        assertEquals(countries.get(0).name, "Russian Federation");
        assertEquals(countries.get(0).region, "Eastern Europe");
    }
    @Test
    void testCountriesRegion()
    {
        ArrayList<Country> countries = Country.countriesRegion("Central America");
        assertEquals(countries.get(0).code, "MEX");
        assertEquals(countries.get(0).name, "Mexico");
        assertEquals(countries.get(0).continent, "North America");
    }

    //City Class Tests
    @Test
    void testCitiesWorld()
    {
        ArrayList<City> cities = City.citiesWorld();
        assertEquals(cities.get(0).name, "Mumbai (Bombay)");
        assertEquals(cities.get(0).country, "India");
        assertEquals(cities.get(0).district, "Maharashtra");

    }

    @Test
    void testCitiesCont()
    {
        ArrayList<City> cities = City.citiesCont("Oceania");
        assertEquals(cities.get(0).name, "Sydney");
        assertEquals(cities.get(0).country, "Australia");
        assertEquals(cities.get(0).district, "New South Wales");

    }
}
