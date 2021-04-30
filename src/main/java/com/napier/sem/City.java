package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * The City class creates objects containing information for a City Report.
 * This is done through a SQL query in the world database, using the Connection Class
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-03-19
 */

public class City
{
    // City Name
    private String name;
    // City Region
    private String country;
    // City District
    private String district;
    // City Population
    private long population;

    /**
     *  Getters and Setters
     */
    public String getName() {return name;}
    public String setName(String name){ this.name = name; return name;}
    public String getCountry() {return country;}
    public String setCountry(String country){ this.country = country; return country;}
    public String getDistrict() {return district;}
    public String setDistrict(String district){ this.district = district; return district;}
    public long getPopulation() {return population;}
    public long setPopulation(long population){ this.population = population; return population;}

    /**
     *  Methods
     */
    // All Cities by Population in the World
    public static ArrayList<City> citiesWorld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // All Cities by Population in x Continent
    public static ArrayList<City> citiesCont(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE Continent = '" +continent+ "' "
                            + "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // All Cities by Population in x Region
    public static ArrayList<City> citiesRegion(String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE Region = '" +region+ "' "
                            + "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // All Cities by Population in x Country
    public static ArrayList<City> citiesCountry(String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.Name = '" +country+ "' "
                            + "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    //  All Cities by Population in x District
    public static ArrayList<City> citiesDistrict(String district)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE District = '" +district+ "' "
                            + "ORDER BY city.Population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    // Display cities
    public static void displayCity(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        System.out.println(String.format("%-17s %-17s %-16s %-14s", "Name", "Country", "District", "Population"));
        for (City city : cities)
        {
            if (city == null)
                continue;
            String city_str =
                    String.format("%-17s %-17s %-16s %-14s",
                            city.name, city.country, city.district, city.population);
            System.out.println(city_str);

        }
        System.out.println("\n");
    }

    public static ArrayList<City> NcitiesDistrict(String district, Integer limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE District = '" +district+ "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT '" +limit+ "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public static ArrayList<City> NcitiesCont(String continent, Integer limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE Continent = '" +continent+ "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT '" +limit+ "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public static ArrayList<City> NcitiesCountry(String country, Integer limit)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String citySelect =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city JOIN country ON city.CountryCode=country.Code "
                            + "WHERE country.Name = '" +country+ "' "
                            + "ORDER BY city.Population DESC "
                            + "LIMIT '" +limit+ "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(citySelect);
            // Return new employee if valid.
            ArrayList<City> cities = new ArrayList<City>();
            // Check one is returned
            while (rset.next()) {
                City city = new City();
                city.name = rset.getString("city.Name");
                city.country =rset.getString("country.Name");
                city.district = rset.getString("District");
                city.population = rset.getLong("city.Population");
                cities.add(city);
            }
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }
}
