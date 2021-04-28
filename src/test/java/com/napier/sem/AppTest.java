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
    static Capital capital;
    static Population population;

    @BeforeAll
    static void init()
    {
        country = new Country();
        capital = new Capital();
        population = new Population();
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


    /**
     * unit tests for the Capital and Population classes
     * testing that their methods work as intended
     *
     * Written by: Mikolaj Figiel on 22/03/2021
     */
    @Test
    void printCapitalTestNull() { capital.displayCapital(null); }
    @Test
    void printCapitalTestEmpty()
    {
        ArrayList<Capital> capitals = new ArrayList<Capital>();
        Capital.displayCapital(capitals);
    }

    @Test
    void printCapitalTestContainsNull()
    {
        ArrayList<Capital> capitals = new ArrayList<Capital>();
        capitals.add(null);
        Capital.displayCapital(capitals);
    }

    @Test
    void printCapitals()
    {
        ArrayList<Capital> capitals = new ArrayList<Capital>();
        Capital capital = new Capital();
        capital.setName("Oslo");
        capital.setCountry("Norway");
        capital.setPopulation(9001);
        capitals.add(capital);
        Capital.displayCapital(capitals);
    }


    @Test
    void printPopulationTestNull(){ population.displayPopulation(null);}
    @Test
    void printPopulationTestEmpty()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        Population.displayPopulation(populations);
    }

    @Test
    void printPopulationTestContainsNull()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        populations.add(null);
        Population.displayPopulation(populations);
    }

    @Test
    void printPopulations()
    {
        ArrayList<Population> populations = new ArrayList<Population>();
        Population population = new Population();
        population.setName("Greenland");
        population.setTotalPop("69420");
        population.setCityPop("69000");
        population.setRuralPop("420");
        Population.displayPopulation(populations);
    }
}
