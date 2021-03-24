package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * The Population class creates objects containing information for a Population Report.
 * This is done through a SQL query in the world database, using the Connection Class
 *
 * @author  Callum Grant
 * @version 1.0
 * @since   2021-03-21
 */
public class Population {

     // Name of area.
    private String name;

     // Total population
    private long totalPop;

    // City Population
    private long cityPop;

     //Rural Population
    private long ruralPop;


    // Getters and Setters
    public String getName()
    {
        return name;
    }
    public String setName(String name)
    {
        this.name = name;
        return name;
    }
    public long getTotalPop()
    {
        return totalPop;
    }
    public long setTotalPop( long totalPop)
    {
        this.totalPop= totalPop;
        return totalPop;
    }
    public long getCityPop()
    {
        return cityPop;
    }
    public long setCityPop( long cityPop)
    {
        this.cityPop= cityPop;
        return cityPop;
    }
    public long getRuralPop()
    {
        return ruralPop;
    }
    public long setRuralPop( long ruralPop)
    {
        this.ruralPop= ruralPop;
        return ruralPop;
    }

    /**
     *  Methods
     */
    public static ArrayList<Population> popContinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Continent, SUM(DISTINCT country.Population), SUM(city.Population), SUM(DISTINCT country.Population)-SUM(city.Population) "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "GROUP BY Continent ORDER BY SUM(country.Population) DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("Continent");
                population.totalPop = rset.getLong("SUM(DISTINCT country.Population)");
                population.cityPop = rset.getLong ("SUM(city.Population)");
                population.ruralPop = rset.getLong ("SUM(DISTINCT country.Population)-SUM(city.Population)");
                populations.add(population);
            }
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public static ArrayList<Population> popRegion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Region, SUM(DISTINCT country.Population), SUM(city.Population), SUM(DISTINCT country.Population)-SUM(city.Population) "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "GROUP BY Region ORDER BY SUM(country.Population) DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("Region");
                population.totalPop = rset.getLong("SUM(DISTINCT country.Population)");
                population.cityPop = rset.getLong("SUM(city.Population)");
                population.ruralPop = rset.getLong("SUM(DISTINCT country.Population)-SUM(city.Population)");
                populations.add(population);
            }
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public static ArrayList<Population> popCountry()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT country.Name, SUM(DISTINCT country.Population), SUM(city.Population), SUM(DISTINCT country.Population)-SUM(city.Population) "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "GROUP BY country.Name ORDER BY SUM(country.Population) DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("country.Name");
                population.totalPop = rset.getLong("SUM(DISTINCT country.Population)");
                population.cityPop = rset.getLong("SUM(city.Population)");
                population.ruralPop = rset.getLong("SUM(DISTINCT country.Population)-SUM(city.Population)");
                populations.add(population);
            }
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population details");
            return null;
        }
    }

    public static void displayPopulation(ArrayList<Population> populations)
    {
        // Check populations is not null
        if (populations == null)
        {
            System.out.println("No population information");
            return;
        }
        System.out.println(String.format("%-18s %-14s %-14s %-14s", "Name", "Total", "City", "Rural"));
        for (Population pop : populations)
        {
            if (pop == null)
                continue;
            String pop_str =
                    String.format("%-18s %-14s %-14s %-14s",
                            pop.getName(), pop.getTotalPop(), pop.getCityPop(), pop.getRuralPop());
            System.out.println(pop_str);
        }
        System.out.println("\n");
    }
}
