package com.napier.sem;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * The Country class creates objects containing information for a Country Report.
 * This is done through a SQL query in the world database, using the Connection Class
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-03-19
 */

public class Country
{
    /**
     * Country Code
     */
    public String code;

    /**
     * Country name
     */
    public String name;

    /**
     * Country Continent
     */
    public String continent;

    /**
     * Country Region
     */
    public String region;


    /**
     * Country Population
     */
    public long population;

    /**
     * Country Capital
     */
    public String capital;


    /**
     *  Methods
     */

    // All countries by Population in World
    public static ArrayList<Country> countriesWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Code, country.Name, Continent, Region, country.Population, city.Name "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "WHERE country.Capital=city.ID "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Country> countries = new ArrayList<Country>();
            // Check one is returned
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getString("city.Name");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    // All countries by Population in x Continent
    public static ArrayList<Country> countriesCont(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Code, country.Name, Continent, Region, country.Population, city.Name "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "WHERE country.Capital=city.ID AND Continent = '" +continent+ "' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Country> countries = new ArrayList<Country>();
            // Check one is returned
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getString("city.Name");
                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    //  All Countries by Population in x Region
    public static ArrayList<Country> countriesRegion(String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Code, country.Name, Continent, Region, country.Population, city.Name "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "WHERE country.Capital=city.ID AND Region = '" +region+ "' "
                            + "ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Country> countries = new ArrayList<Country>();
            // Check one is returned
            while (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("Code");
                country.name = rset.getString("country.Name");
                country.continent = rset.getString("Continent");
                country.region = rset.getString("Region");
                country.population = rset.getLong("country.Population");
                country.capital = rset.getString("city.Name");
                countries.add(country);
            }
            return countries;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    // Display country to console
    public static void displayCountry(ArrayList<Country> countries)
    {
        // Check employees is not null
        if (countries == null)
        {
            System.out.println("No countries");
            return;
        }
        System.out.println(String.format("%-8s %-14s %-17s %-16s %-14s %-10s", "Code", "Name", "Continent", "Region", "Population", "Capital"));
        // Loop over all employees in the list
        for (Country country : countries)
        {
            if (country == null)
                continue;
            String country_str =
                    String.format("%-8s %-14s %-17s %-16s %-14s %-10s",
                            country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println(country_str);

        }
        System.out.println("\n");
    }
}
