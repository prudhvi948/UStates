package com.ustates.app;

/**
 * Created by prudhvi on 7/2/2014.
 * This class creates object which is used as a record in table2 (weblinks)
 */
public class StateWebLinks {
    private int id;
    private String stateWiki;
    private String capitalWiki;
    private String largestCityWiki;
    private String stateWeb;
    private String tourismWeb;
    private String mapLocation;

    public StateWebLinks()
    {

    }

    public StateWebLinks(int id, String stateWiki, String capitalWiki, String largestCityWiki,
                         String stateWeb, String tourismWeb, String mapLocation)
    {
        this.id = id;
        this.stateWiki = stateWiki;
        this.capitalWiki = capitalWiki;
        this.largestCityWiki = largestCityWiki;
        this.stateWeb = stateWeb;
        this.tourismWeb = tourismWeb;
        this.mapLocation = mapLocation;
    }

    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }

    public void setStateWiki(String stateWiki)
    {
        this.stateWiki = stateWiki;
    }
    public String getStateWiki()
    {
        return stateWiki;
    }

    public void setCapitalWiki(String capitalWiki)
    {
        this.capitalWiki = capitalWiki;
    }
    public String getCapitalWiki()
    {
        return capitalWiki;
    }

    public void setLargestCityWiki(String largestCityWiki)
    {
        this.largestCityWiki = largestCityWiki;
    }
    public String getLargestCityWiki()
    {
        return largestCityWiki;
    }

    public void setStateWeb(String stateWeb)
    {
        this.stateWeb = stateWeb;
    }
    public String getStateWeb()
    {
        return stateWeb;
    }

    public void setTourismWeb(String tourismWeb)
    {
        this.tourismWeb = tourismWeb;
    }
    public String getTourismWeb()
    {
        return tourismWeb;
    }

    public void setMapLocation(String mapLocation)
    {
        this.mapLocation = mapLocation;
    }
    public String getMapLocation()
    {
        return mapLocation;
    }
}
