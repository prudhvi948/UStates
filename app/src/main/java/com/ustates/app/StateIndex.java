package com.example.unitedstates.app;



/**
 * Created by prudhvi on 5/21/2014.
 * This class creates object which is used as a record in table1 (states)
 */
public class StateIndex {
    private int id;
    private String name;
    private String abbreviation;
    private String nickname;
    private String demonym;
    private String capital;
    private String largestCity;
    private String area;
    private String areaRank;
    private String population;
    private String populationRank;
    private String year;
    private String timezone;
    private String website;
    private String tourism;

    public StateIndex()
    {

    }

    public StateIndex(int id, String name, String abbreviation, String nickname, String demonym,
                      String capital, String largestCity, String area, String areaRank,
                      String population, String populationRank, String year, String timezone, String website, String tourism)
    {
        this.id = id;
        this.name = name;
        this.abbreviation = abbreviation;
        this.nickname = nickname;
        this.demonym = demonym;
        this.capital = capital;
        this.largestCity = largestCity;
        this.area= area;
        this.areaRank = areaRank;
        this.population = population;
        this.populationRank = populationRank;
        this.year = year;
        this.timezone = timezone;
        this.website = website;
        this.tourism = tourism;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setAbbreviation(String abbreviation)
    {
        this.abbreviation = abbreviation;
    }
    public String getAbbreviation()
    {
        return abbreviation;
    }

    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
    public String getNickname()
    {
        return nickname;
    }

    public void setDemonym(String demonym)
    {
        this.demonym = demonym;
    }
    public String getDemonym()
    {
        return demonym;
    }

    public void setCapital(String capital)
    {
        this.capital = capital;
    }
    public String getCapital()
    {
        return capital;
    }

    public void setLargestCity(String largestCity)
    {
        this.largestCity = largestCity;
    }
    public String getLargestCity()
    {
        return largestCity;
    }

    public void setArea(String area)
    {
        this.area = area;
    }
    public String getArea()
    {
        return area;
    }

    public void setAreaRank(String areaRank)
    {
        this.areaRank = areaRank;
    }
    public String getAreaRank()
    {
        return areaRank;
    }

    public void setPopulation(String population)
    {
        this.population= population;
    }
    public String getPopulation()
    {
        return population;
    }

    public void setPopulationRank(String populationRank)
    {
        this.populationRank = populationRank;
    }
    public String getPopulationRank()
    {
        return populationRank;
    }

    public void setYear(String year)
    {
        this.year = year;
    }
    public String getYear()
    {
        return year;
    }

    public void setTimezone(String timezone)
    {
        this.timezone = timezone;
    }
    public String getTimezone()
    {
        return timezone;
    }

    public void setWebsite(String website)
    {
        this.website = website;
    }
    public String getWebsite()
    {
        return website;
    }

    public void setTourism(String tourism)
    {
        this.tourism = tourism;
    }
    public String getTourism()
    {
        return tourism;
    }
}
