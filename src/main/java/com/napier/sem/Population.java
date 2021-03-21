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
                            pop.name, pop.totalPop, pop.cityPop, pop.ruralPop);
            System.out.println(pop_str);
        }
        System.out.println("\n");
    }
}
