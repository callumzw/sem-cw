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
    private String totalPop;

    // City Population
    private String cityPop;

     //Rural Population
    private String ruralPop;


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
    public String getTotalPop()
    {
        return totalPop;
    }
    public String setTotalPop( String totalPop)
    {
        this.totalPop= totalPop;
        return totalPop;
    }
    public String getCityPop()
    {
        return cityPop;
    }
    public String setCityPop( String cityPop)
    {
        this.cityPop= cityPop;
        return cityPop;
    }
    public String getRuralPop()
    {
        return ruralPop;
    }
    public String setRuralPop( String ruralPop)
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
                    "SELECT Continent, SUM(DISTINCT country.Population) AS Total, SUM(city.Population) AS City, SUM(DISTINCT country.Population)-SUM(city.Population) AS Rural "
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
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("City");
                population.cityPop = population.cityPop + "(" + (long)(Double.parseDouble(population.cityPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
                population.ruralPop = rset.getString ("Rural");
                population.ruralPop = population.ruralPop + "(" + (long)(Double.parseDouble(population.ruralPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
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
                    "SELECT Region, SUM(DISTINCT country.Population) AS Total, SUM(city.Population) AS City, SUM(DISTINCT country.Population)-SUM(city.Population) AS Rural "
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
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("City");
                population.cityPop = population.cityPop + "(" + (long)(Double.parseDouble(population.cityPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
                population.ruralPop = rset.getString ("Rural");
                population.ruralPop = population.ruralPop + "(" + (long)(Double.parseDouble(population.ruralPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
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
                    "SELECT country.Name, SUM(DISTINCT country.Population) AS Total, SUM(city.Population) AS City, SUM(DISTINCT country.Population)-SUM(city.Population) AS Rural  "
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
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("City");
                population.cityPop = population.cityPop + "(" + (long)(Double.parseDouble(population.cityPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
                population.ruralPop = rset.getString ("Rural");
                population.ruralPop = population.ruralPop + "(" + (long)(Double.parseDouble(population.ruralPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
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

    public static ArrayList<Population> worldPop()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT SUM(DISTINCT country.Population) AS Total, SUM(city.Population) AS City, SUM(DISTINCT country.Population)-SUM(city.Population) AS Rural "
                            + "FROM country JOIN city ON city.CountryCode=country.Code ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = "World";
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("City");
                population.cityPop = population.cityPop + "(" + (long)(Double.parseDouble(population.cityPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
                population.ruralPop = rset.getString ("Rural");
                population.ruralPop = population.ruralPop + "(" + (long)(Double.parseDouble(population.ruralPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
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

    public static ArrayList<Population> continentPop(String continent)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Continent, SUM(DISTINCT country.Population) AS Total, SUM(city.Population) AS City, SUM(DISTINCT country.Population)-SUM(city.Population) AS Rural "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "WHERE Continent = '" +continent+ "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("Continent");
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("City");
                population.cityPop = population.cityPop + "(" + (long)(Double.parseDouble(population.cityPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
                population.ruralPop = rset.getString ("Rural");
                population.ruralPop = population.ruralPop + "(" + (long)(Double.parseDouble(population.ruralPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
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

    public static ArrayList<Population> regionPop(String region)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Region,SUM(DISTINCT country.Population) AS Total, SUM(city.Population) AS City, SUM(DISTINCT country.Population)-SUM(city.Population) AS Rural "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "WHERE Region = '" +region+ "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("Region");
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("City");
                population.cityPop = population.cityPop + "(" + (long)(Double.parseDouble(population.cityPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
                population.ruralPop = rset.getString ("Rural");
                population.ruralPop = population.ruralPop + "(" + (long)(Double.parseDouble(population.ruralPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
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

    public static ArrayList<Population> countryPop(String country)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT country.Name,SUM(DISTINCT country.Population) AS Total, SUM(city.Population) AS City, SUM(DISTINCT country.Population)-SUM(city.Population) AS Rural "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "WHERE country.Name = '" +country+ "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("country.Name");
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("City");
                population.cityPop = population.cityPop + "(" + (long)(Double.parseDouble(population.cityPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
                population.ruralPop = rset.getString ("Rural");
                population.ruralPop = population.ruralPop + "(" + (long)(Double.parseDouble(population.ruralPop) / Double.parseDouble(population.totalPop) * 100) + "%)";
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

    public static ArrayList<Population> districtPop(String district)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT city.District,SUM(DISTINCT city.Population) AS Total "
                            + "FROM country JOIN city ON city.CountryCode=country.Code "
                            + "WHERE city.District = '" +district+ "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("city.District");
                population.totalPop = rset.getString("Total");
                population.cityPop = rset.getString ("Total") + "(100%)";
                population.ruralPop = "0 (0%)";
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

    public static ArrayList<Population> cityPop(String city)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = Connection.getCon().createStatement();
            // Create string for SQL statement
            String countrySelect =
                    "SELECT Name, Population "
                            + "FROM city "
                            + "WHERE Name = '" +city+ "' ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countrySelect);
            // Return new employee if valid.
            ArrayList<Population> populations = new ArrayList<Population>();
            // Check one is returned
            while (rset.next())
            {
                Population population = new Population();
                population.name = rset.getString("Name");
                population.totalPop = rset.getString("Population");
                population.cityPop = rset.getString("Population") + "(100%)";
                population.ruralPop = "0 (0%)";
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
