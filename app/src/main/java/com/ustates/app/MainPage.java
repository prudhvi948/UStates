package com.ustates.app;


import android.app.ActionBar;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;


public class MainPage extends ActionBarActivity {
    public static UnitedStatesDatabaseHelper databaseHelper;
    MainPageAdapter mainPageAdapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        databaseHelper = new UnitedStatesDatabaseHelper(this);
        ActionBar actionBar = getActionBar();
        actionBar.setIcon(R.drawable.ic_launcher);

        /* Moving some expensive database work out of UI thread by creating thread1*/
        Thread thread1 = new Thread() {
            public void run() {
                createDatabase();
            }
        };
        thread1.start();

        /* MainPageAdapter works with the data behind the ListView*/
        mainPageAdapter = new MainPageAdapter();
        ListView listView = (ListView)findViewById(R.id.main_list);
        listView.setAdapter(mainPageAdapter);
        listView.setTextFilterEnabled(true);

        /* Code to show specific viewpager connected to an item in the listview
        * Each item in the listview is mapped to their respective pages in the viewpager*/
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), StatePage.class);
                String itemName = adapterView.getItemAtPosition(i).toString();
                switch(itemName)
                {
                    case "Alabama":
                        intent.putExtra("page number", 0);
                        break;
                    case "Alaska":
                        intent.putExtra("page number", 1);
                        break;
                    case "Arizona":
                        intent.putExtra("page number", 2);
                        break;
                    case "Arkansas":
                        intent.putExtra("page number", 3);
                        break;
                    case "California":
                        intent.putExtra("page number", 4);
                        break;
                    case "Colorado":
                        intent.putExtra("page number", 5);
                        break;
                    case "Connecticut":
                        intent.putExtra("page number", 6);
                        break;
                    case "Delaware":
                        intent.putExtra("page number", 7);
                        break;
                    case "Florida":
                        intent.putExtra("page number", 8);
                        break;
                    case "Georgia":
                        intent.putExtra("page number", 9);
                        break;
                    case "Hawaii":
                        intent.putExtra("page number", 10);
                        break;
                    case "Idaho":
                        intent.putExtra("page number", 11);
                        break;
                    case "Illinois":
                        intent.putExtra("page number", 12);
                        break;
                    case "Indiana":
                        intent.putExtra("page number", 13);
                        break;
                    case "Iowa":
                        intent.putExtra("page number", 14);
                        break;
                    case "Kansas":
                        intent.putExtra("page number", 15);
                        break;
                    case "Kentucky":
                        intent.putExtra("page number", 16);
                        break;
                    case "Louisiana":
                        intent.putExtra("page number", 17);
                        break;
                    case "Maine":
                        intent.putExtra("page number", 18);
                        break;
                    case "Maryland":
                        intent.putExtra("page number", 19);
                        break;
                    case "Massachusetts":
                        intent.putExtra("page number", 20);
                        break;
                    case "Michigan":
                        intent.putExtra("page number", 21);
                        break;
                    case "Minnesota":
                        intent.putExtra("page number", 22);
                        break;
                    case "Mississippi":
                        intent.putExtra("page number", 23);
                        break;
                    case "Missouri":
                        intent.putExtra("page number", 24);
                        break;
                    case "Montana":
                        intent.putExtra("page number", 25);
                        break;
                    case "Nebraska":
                        intent.putExtra("page number", 26);
                        break;
                    case "Nevada":
                        intent.putExtra("page number", 27);
                        break;
                    case "New Hampshire":
                        intent.putExtra("page number", 28);
                        break;
                    case "New Jersey":
                        intent.putExtra("page number", 29);
                        break;
                    case "New Mexico":
                        intent.putExtra("page number", 30);
                        break;
                    case "New York":
                        intent.putExtra("page number", 31);
                        break;
                    case "North Carolina":
                        intent.putExtra("page number", 32);
                        break;
                    case "North Dakota":
                        intent.putExtra("page number", 33);
                        break;
                    case "Ohio":
                        intent.putExtra("page number", 34);
                        break;
                    case "Oklahoma":
                        intent.putExtra("page number", 35);
                        break;
                    case "Oregon":
                        intent.putExtra("page number", 36);
                        break;
                    case "Pennsylvania":
                        intent.putExtra("page number", 37);
                        break;
                    case "Rhode Island":
                        intent.putExtra("page number", 38);
                        break;
                    case "South Carolina":
                        intent.putExtra("page number", 39);
                        break;
                    case "South Dakota":
                        intent.putExtra("page number", 40);
                        break;
                    case "Tennessee":
                        intent.putExtra("page number", 41);
                        break;
                    case "Texas":
                        intent.putExtra("page number", 42);
                        break;
                    case "Utah":
                        intent.putExtra("page number", 43);
                        break;
                    case "Vermont":
                        intent.putExtra("page number", 44);
                        break;
                    case "Virginia":
                        intent.putExtra("page number", 45);
                        break;
                    case "Washington":
                        intent.putExtra("page number", 46);
                        break;
                    case "West Virginia":
                        intent.putExtra("page number", 47);
                        break;
                    case "Wisconsin":
                        intent.putExtra("page number", 48);
                        break;
                    case "Wyoming":
                        intent.putExtra("page number", 49);
                        break;
                    default:

                }
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_main_actions, menu);
        SearchManager searchManager = (SearchManager)getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();

        /* Code used to customize search icon in place of the default icon*/
        int searchImageId = getResources().getIdentifier("android:id/search_button", null, null);
        ImageView imageView = (ImageView)searchView.findViewById(searchImageId);
        imageView.setImageResource(R.drawable.ic_action_search);

        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setQueryHint("Search State..");

        /* Code used to disable fullscreen mode when searching in landscape mode*/
        if (android.os.Build.VERSION.SDK_INT >= 16) {
            searchView.setImeOptions(searchView.getImeOptions() | EditorInfo.IME_FLAG_NO_EXTRACT_UI | EditorInfo.IME_FLAG_NO_FULLSCREEN);
        }

        /* Code to set the text in the search bar to white color*/
        int searchTextId = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
        TextView textView = (TextView)searchView.findViewById(searchTextId);
        textView.setTextColor(Color.WHITE);

        SearchView.OnQueryTextListener textListener = new SearchView.OnQueryTextListener(){

            /* Methods to handle search option in the menu when text is entered in the searchview*/
            @Override
            public boolean onQueryTextSubmit(String s) {
                mainPageAdapter.getFilter().filter(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mainPageAdapter.getFilter().filter(s);
                return true;
            }
        };
        searchView.setOnQueryTextListener(textListener);

        SearchView.OnCloseListener closeListener = new SearchView.OnCloseListener(){

            @Override
            public boolean onClose() {
                return false;
            }
        };
        searchView.setOnCloseListener(closeListener);

        return super.onCreateOptionsMenu(menu);
    }

    /*Method to handle overflow's dropdown menus in the action bar*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        Intent intent;
        int id = item.getItemId();
        switch(id)
        {
            case R.id.action_help:
                intent = new Intent(this, Help.class);
                startActivity(intent);
                return true;
            case R.id.action_about:
                intent = new Intent(this, About.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /* Method to display "No State Found" when search results in empty list view*/
    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
        View emptyList = findViewById(R.id.empty_list);
        ListView listView = (ListView)findViewById(R.id.main_list);
        listView.setEmptyView(emptyList);
    }

    /* Method to add data into 2 tables in the database*/
    public UnitedStatesDatabaseHelper createDatabase()
    {
        databaseHelper.addStateRecord(new StateIndex(1, "Alabama", "AL", "The Yellow Hammer State",
                "Alabamian", "Montgomery", "Birmingham", "52,419 sq mi", "30", "4,833,722 (2013 est.)",
                "23", "1819", "Central & Eastern", "www.alabama.gov", "www.alabama.travel"));
        databaseHelper.addStateRecord(new StateIndex(2, "Alaska", "AK", "The Last Frontier",
                "Alaskan", "Juneau", "Anchorage", "663,268 sq mi", "1", "735,132 (2013 est.)",
                "47", "1959", "Alaska & Aleutian", "www.alaska.gov", "www.travelalaska.com"));
        databaseHelper.addStateRecord(new StateIndex(3, "Arizona", "AZ", "The Grand Canyon State",
                "Arizonan", "Phoenix", "Phoenix", "113,990 sq mi", "6", "6,626,624 (2013 est.)",
                "15", "1912", "Mountain", "www.az.gov", "www.arizonaguide.com"));
        databaseHelper.addStateRecord(new StateIndex(4, "Arkansas", "AR", "The Natural State",
                "Arkansan", "Little Rock", "Little Rock", "53,179 sq mi", "29", "2,949,131 (2012 est.)",
                "32", "1836", "Central", "www.arkansas.gov", "www.arkansas.com"));
        databaseHelper.addStateRecord(new StateIndex(5, "California", "CA", "The Golden State",
                "Californian", "Sacramento", "Los Angeles", "163,696 sq mi", "3", "38,340,000 (2013 est.)",
                "1", "1850", "Pacific", "www.ca.gov", "www.visitcalifornia.com"));
        databaseHelper.addStateRecord(new StateIndex(6, "Colorado", "CO", "The Centennial State",
                "Coloradan", "Denver", "Denver", "104,094 sq mi", "8", "5,268,367 (2013 est.)",
                "22", "1876", "Mountain", "www.colorado.gov", "www.colorado.com"));
        databaseHelper.addStateRecord(new StateIndex(7, "Connecticut", "CT", "The Constitution State",
                "Connecticuter", "Hartford", "Bridgeport", "5,543 sq mi", "48", "3,596,080 (2013 est.)",
                "29", "1788", "Eastern", "www.ct.gov", "www.ctvisit.com"));
        databaseHelper.addStateRecord(new StateIndex(8, "Delaware", "DE", "The First State",
                "Delawarean", "Dover", "Wilmington", "1,982 sq mi", "49", "917,092 (2012 est.)",
                "45", "1787", "Eastern", "www.delaware.gov", "www.visitdelaware.com"));
        databaseHelper.addStateRecord(new StateIndex(9, "Florida", "FL", "The Sunshine State",
                "Floridian", "Tallahassee", "Jacksonville", "65,755 sq mi", "22", "19,552,860 (2013 est.)",
                "4", "1845", "Eastern & Central", "www.myflorida.com", "www.visitflorida.com"));
        databaseHelper.addStateRecord(new StateIndex(10, "Georgia", "GA", "The Peach State",
                "Georgian", "Atlanta", "Atlanta", "59,425 sq mi", "24", "9,992,167 (2013 est.)",
                "8", "1788", "Eastern", "www.georgia.gov", "www.exploregeorgia.org"));
        databaseHelper.addStateRecord(new StateIndex(11, "Hawaii", "HI", "The Aloha State",
                "Hawaiian", "Honolulu", "Honolulu", "10,931 sq mi", "43", "1,404,054 (2013 est.)",
                "40", "1959", "Hawaiian", "www.hawaii.gov", "www.gohawaii.com"));
        databaseHelper.addStateRecord(new StateIndex(12, "Idaho", "ID", "The Gem State",
                "Idahoan", "Boise", "Boise", "83,570 sq mi", "14", "1,595,728 (2012 est.)",
                "39", "1890", "Pacific & Mountain", "www.idaho.gov", "www.visitidaho.org"));
        databaseHelper.addStateRecord(new StateIndex(13, "Illinois", "IL", "The Prairie State",
                "Illinoisan", "Springfield", "Chicago", "57,914 sq mi", "25", "12,882,135 (2013 est.)",
                "5", "1818", "Central", "www.illinois.gov", "www.enjoyillinois.com"));
        databaseHelper.addStateRecord(new StateIndex(14, "Indiana", "IN", "The Hoosier State",
                "Hoosier", "Indianapolis", "Indianapolis", "36,418 sq mi", "38", "6,570,902 (2013 est.)",
                "16", "1816", "Eastern & Central", "www.in.gov", "www.visitindiana.com"));
        databaseHelper.addStateRecord(new StateIndex(15, "Iowa", "IA", "The Hawkeye State",
                "Iowan", "Des Moines", "Des Moines", "56,272 sq mi", "26", "3,090,416 (2013 est.)",
                "30", "1846", "Central", "www.iowa.gov", "www.traveliowa.com"));
        databaseHelper.addStateRecord(new StateIndex(16, "Kansas", "KS", "The Sunflower State",
                "Kansan", "Topeka", "Wichita", "82,277 sq mi", "15", "2,893,957 (2013 est.)",
                "34", "1861", "Central & Mountain", "www.kansas.gov", "www.travelks.com"));
        databaseHelper.addStateRecord(new StateIndex(17, "Kentucky", "KY", "The Bluegrass State",
                "Kentuckian", "Frankfort", "Louisville", "40,409 sq mi", "37", "4,395,295 (2013 est.)",
                "26", "1792", "Eastern & Central", "www.kentucky.gov", "www.kentuckytourism.com"));
        databaseHelper.addStateRecord(new StateIndex(18, "Louisiana", "LA", "The Pelican State",
                "Louisianan", "Baton Rouge", "New Orleans", "51,843 sq mi", "31", "4,601,893 (2012 est.)",
                "25", "1812", "Central", "www.louisiana.gov", "www.louisianatravel.com"));
        databaseHelper.addStateRecord(new StateIndex(19, "Maine", "ME", "The Pine Tree State",
                "Mainer", "Augusta", "Portland", "35,385 sq mi", "39", "1,328,302 (2013 est.)",
                "41", "1820", "Eastern", "www.maine.gov", "www.visitmaine.com"));
        databaseHelper.addStateRecord(new StateIndex(20, "Maryland", "MD", "The Old Line State",
                "Marylander", "Annapolis", "Baltimore", "12,407 sq mi", "42", "5,928,814 (2013 est.)",
                "19", "1788", "Eastern", "www.maryland.gov", "www.visitmaryland.org"));
        databaseHelper.addStateRecord(new StateIndex(21, "Massachusetts", "MA", "The Bay State",
                "Bay Stater", "Boston", "Boston", "10,555 sq mi", "44", "6,692,824 (2013 est.)",
                "14", "1788", "Eastern", "www.mass.gov", "www.massvacation.com"));
        databaseHelper.addStateRecord(new StateIndex(22, "Michigan", "MI", "The Great Lakes State",
                "Michigander", "Lansing", "Detroit", "96,716 sq mi", "11", "9,895,622 (2013 est.)",
                "9", "1837", "Eastern & Central", "www.michigan.gov", "www.michigan.org"));
        databaseHelper.addStateRecord(new StateIndex(23, "Minnesota", "MN", "The North Star State",
                "Minnesotan", "Saint Paul", "Minneapolis", "86,939 sq mi", "12", "5,420,380 (2013 est.)",
                "21", "1858", "Central", "www.mn.gov", "www.exploreminnesota.com"));
        databaseHelper.addStateRecord(new StateIndex(24, "Mississippi", "MS", "The Magnolia State",
                "Mississippian", "Jackson", "Jackson", "48,430 sq mi", "32", "2,984,926 (2012 est.)",
                "31", "1817", "Central", "www.ms.gov", "www.visitmississippi.org"));
        databaseHelper.addStateRecord(new StateIndex(25, "Missouri", "MO", "The Show-Me State",
                "Missourian ", "Jefferson City", "Kansas City", "69,709 sq mi", "21", "6,044,171 (2013 est.)",
                "18", "1821", "Central", "www.mo.gov", "www.visitmo.com"));
        databaseHelper.addStateRecord(new StateIndex(26, "Montana", "MT", "The Treasure State",
                "Montanan", "Helena", "Billings", "147,040 sq mi", "4", "1,015,165 (2013 est.)",
                "44", "1889", "Mountain", "www.mt.gov", "www.visitmt.com"));
        databaseHelper.addStateRecord(new StateIndex(27, "Nebraska", "NE", "The Cornhusker State",
                "Nebraskan", "Lincoln", "Omaha", "77,354 sq mi", "16", "1,868,516 (2013 est.)",
                "37", "1867", "Mountain & Central", "www.nebraska.gov", "www.visitnebraska.org"));
        databaseHelper.addStateRecord(new StateIndex(28, "Nevada", "NV", "The Silver State",
                "Nevadan", "Carson City", "Las Vegas", "110,622 sq mi", "7", "2,758,931 (2012 est.)",
                "35", "1864", "Pacific & Mountain", "www.nv.gov", "www.nevadatourism.com"));
        databaseHelper.addStateRecord(new StateIndex(29, "New Hampshire", "NH", "The Granite State",
                "New Hampshirite", "Concord", "Manchester", "9,304 sq mi", "46", "1,323,459 (2013 est.)",
                "42", "1788", "Eastern", "www.nh.gov", "www.visitnh.gov"));
        databaseHelper.addStateRecord(new StateIndex(30, "New Jersey", "NJ", "The Garden State",
                "New Jerseyan", "Trenton", "Newark", "8,723 sq mi", "47", "8,899,339 (2013 est.)",
                "11", "1787", "Eastern", "www.nj.gov", "www.visitnj.org"));
        databaseHelper.addStateRecord(new StateIndex(31, "New Mexico", "NM", "The Land of Enchantment",
                "New Mexican", "Santa Fe", "Albuquerque", "121,589 sq mi", "5", "2,085,538 (2012 est.)",
                "36", "1912", "Mountain", "www.newmexico.gov", "www.newmexico.org"));
        databaseHelper.addStateRecord(new StateIndex(32, "New York", "NY", "The Empire State",
                "New Yorker", "Albany", "New York City", "54,556 sq mi", "27", "19,651,127 (2013 est.)",
                "3", "1788", "Eastern", "www.ny.gov", "www.newyork.com"));
        databaseHelper.addStateRecord(new StateIndex(33, "North Carolina", "NC", "The Tar Heel State",
                "North Carolinian", "Raleigh", "Charlotte", "53,819 sq mi", "28", "9,848,060 (2013 est.)",
                "10", "1789", "Eastern", "www.nc.gov", "www.visitnc.com"));
        databaseHelper.addStateRecord(new StateIndex(34, "North Dakota", "ND", "The Peace Garden State",
                "North Dakotan", "Bismarck", "Fargo", "70,700 sq mi", "19", "723,393 (2013 est.)",
                "48", "1889", "Mountain & Central", "www.nd.gov", "www.ndtourism.com"));
        databaseHelper.addStateRecord(new StateIndex(35, "Ohio", "OH", "The Buckeye State",
                "Ohioan", "Columbus", "Columbus", "44,825 sq mi", "34", "11,570,808 (2013 est.)",
                "7", "1803", "Eastern", "www.ohio.gov", "consumer.discoverohio.com"));
        databaseHelper.addStateRecord(new StateIndex(36, "Oklahoma", "OK", "The Sooner State",
                "Oklahoman", "Oklahoma City", "Oklahoma City", "69,898 sq mi", "20", "3,850,568 (2013 est.)",
                "28", "1907", "Central & Mountain", "www.ok.gov", "www.travelok.com"));
        databaseHelper.addStateRecord(new StateIndex(37, "Oregon", "OR", "The Beaver State",
                "Oregonian", "Salem", "Portland", "98,381 sq mi", "9", "3,899,353 (2012 est.)",
                "27", "1859", "Pacific & Mountain", "www.oregon.gov", "www.traveloregon.com"));
        databaseHelper.addStateRecord(new StateIndex(38, "Pennsylvania", "PA", "The Keystone State",
                "Pennsylvanian", "Harrisburg", "Philadelphia", "46,055 sq mi", "33", "12,773,801 (2013 est.)",
                "6", "1787", "Eastern", "www.pa.gov", "www.visitpa.com"));
        databaseHelper.addStateRecord(new StateIndex(39, "Rhode Island", "RI", "The Ocean State",
                "Rhode Islander", "Providence", "Providence", "1,214 sq mi", "50", "1,050,292 (2012 est.)",
                "43", "1790", "Eastern", "www.ri.gov", "www.visitrhodeisland.com"));
        databaseHelper.addStateRecord(new StateIndex(40, "South Carolina", "SC", "The Palmetto State",
                "South Carolinian", "Columbia", "Columbia", "32,020 sq mi", "40", "4,774,839 (2013 est.)",
                "24", "1788", "Eastern", "www.sc.gov", "discoversouthcarolina.com"));
        databaseHelper.addStateRecord(new StateIndex(41, "South Dakota", "SD", "The Mount Rushmore State",
                "South Dakotan", "Pierre", "Sioux Falls", "77,116 sq mi", "17", "844,877 (2013 est.)",
                "46", "1889", "Mountain & Central", "www.sd.gov", "www.travelsd.com"));
        databaseHelper.addStateRecord(new StateIndex(42, "Tennessee", "TN", "The Volunteer State",
                "Tennessean", "Nashville", "Memphis", "42,143 sq mi", "36", "6,495,978 (2013 est.)",
                "17", "1796", "Eastern & Central", "www.tennessee.gov", "www.tnvacation.com"));
        databaseHelper.addStateRecord(new StateIndex(43, "Texas", "TX", "The Lone Star State",
                "Texan", "Austin", "Houston", "268,581 sq mi", "2", "26,448,193 (2013 est.)",
                "2", "1845", "Central & Mountain", "www.texas.gov", "www.traveltex.com"));
        databaseHelper.addStateRecord(new StateIndex(44, "Utah", "UT", "The Beehive State",
                "Utahn", "Salt Lake City", "Salt Lake City", "84,899 sq mi", "13", "2,900,872 (2013 est.)",
                "33", "1896", "Mountain", "www.utah.gov", "www.visitutah.com"));
        databaseHelper.addStateRecord(new StateIndex(45, "Vermont", "VT", "The Green Mountain State",
                "Vermonter", "Montpelier", "Burlington", "9,620 sq mi", "45", "626,630 (2013 est.)",
                "49", "1791", "Eastern", "www.vermont.gov", "www.vermontvacation.com"));
        databaseHelper.addStateRecord(new StateIndex(46, "Virginia", "VA", "The Old Dominion State",
                "Virginian", "Richmond", "Virginia Beach", "42,774 sq mi", "35", "8,260,405 (2013 est.)",
                "12", "1788", "Eastern", "www.virginia.gov", "www.virginia.org"));
        databaseHelper.addStateRecord(new StateIndex(47, "Washington", "WA", "The Evergreen State",
                "Washingtonian", "Olympia", "Seattle", "71,362 sq mi", "18", "6,971,406 (2013 est.)",
                "13", "1889", "Pacific", "www.access.wa.gov", "www.experiencewa.com"));
        databaseHelper.addStateRecord(new StateIndex(48, "West Virginia", "WV", "The Mountain State",
                "West Virginian", "Charleston", "Charleston", "24,230 sq mi", "41", "1,854,304 (2013 est.)",
                "38", "1863", "Eastern", "www.wv.gov", "www.wvtourism.com"));
        databaseHelper.addStateRecord(new StateIndex(49, "Wisconsin", "WI", "The Badger State",
                "Wisconsinite", "Madison", "Milwaukee", "65,498 sq mi", "23", "5,726,398 (2012 est.)",
                "20", "1848", "Central", "www.wisconsin.gov", "www.travelwisconsin.com"));
        databaseHelper.addStateRecord(new StateIndex(50, "Wyoming", "WY", "The Equality State",
                "Wyomingite", "Cheyenne", "Cheyenne", "97,814 sq mi", "10", "582,658 (2013 est.)",
                "50", "1890", "Mountain", "www.wyoming.gov", "www.wyomingtourism.org"));

        databaseHelper.addWebRecord(new StateWebLinks(1, "http://en.m.wikipedia.org/wiki/alabama",
                "http://en.m.wikipedia.org/wiki/Montgomery,_Alabama",
                "http://en.m.wikipedia.org/wiki/Birmingham,_Alabama",
                "http://www.alabama.gov/", "http://www.alabama.travel", "geo:32.37,-86.31?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(2, "http://en.m.wikipedia.org/wiki/alaska",
                "http://en.m.wikipedia.org/wiki/Juneau,_Alaska",
                "http://en.wikipedia.org/wiki/Anchorage,_Alaska",
                "http://www.alaska.gov/", "http://www.travelalaska.com/", "geo:64.74,-151.65?z=5"));
        databaseHelper.addWebRecord(new StateWebLinks(3, "http://en.m.wikipedia.org/wiki/arizona",
                "http://en.m.wikipedia.org/wiki/Phoenix,_Arizona",
                "http://en.m.wikipedia.org/wiki/Phoenix,_Arizona",
                "http://www.az.gov/", "http://www.arizonaguide.com", "geo:33.56,-112.15?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(4, "http://en.m.wikipedia.org/wiki/arkansas",
                "http://en.m.wikipedia.org/wiki/Little_Rock,_Arkansas",
                "http://en.m.wikipedia.org/wiki/Little_Rock,_Arkansas",
                "http://www.arkansas.gov/", "http://www.arkansas.com", "geo:34.75,-92.30?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(5, "http://en.m.wikipedia.org/wiki/california",
                "http://en.m.wikipedia.org/wiki/Sacramento,_California",
                "http://en.m.wikipedia.org/wiki/Los_Angeles",
                "http://www.ca.gov/", "http://www.visitcalifornia.com", "geo:38.57,-121.50?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(6, "http://en.m.wikipedia.org/wiki/colorado",
                "http://en.m.wikipedia.org/wiki/Denver",
                "http://en.m.wikipedia.org/wiki/Denver",
                "http://www.colorado.gov/", "http://www.colorado.com", "geo:39.77,-105.04?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(7, "http://en.m.wikipedia.org/wiki/connecticut",
                "http://en.wikipedia.org/wiki/Hartford,_Connecticut",
                "http://en.wikipedia.org/wiki/Bridgeport,_Connecticut",
                "http://www.ct.gov/", "http://www.ctvisit.com", "geo:41.76,-72.68?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(8, "http://en.m.wikipedia.org/wiki/delaware",
                "http://en.m.wikipedia.org/wiki/Dover,_Delaware",
                "http://en.m.wikipedia.org/wiki/Wilmington,_Delaware",
                "http://www.delaware.gov/", "http://www.visitdelaware.com", "geo:39.19,-75.52?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(9, "http://en.m.wikipedia.org/wiki/florida",
                "http://en.wikipedia.org/wiki/Tallahassee,_Florida",
                "http://en.wikipedia.org/wiki/Jacksonville,_Florida",
                "http://www.myflorida.com", "http://www.visitflorida.com", "geo:27.55,-81.72?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(10, "http://en.m.wikipedia.org/wiki/georgia",
                "http://en.wikipedia.org/wiki/Atlanta",
                "http://en.wikipedia.org/wiki/Atlanta",
                "http://www.georgia.gov", "http://www.exploregeorgia.org", "geo:33.77,-84.42?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(11, "http://en.m.wikipedia.org/wiki/hawaii",
                "http://en.wikipedia.org/wiki/Honolulu",
                "http://en.wikipedia.org/wiki/Honolulu",
                "http://www.hawaii.gov", "http://www.gohawaii.com", "geo:21.33,-157.86?z=6"));
        databaseHelper.addWebRecord(new StateWebLinks(12, "http://en.m.wikipedia.org/wiki/idaho",
                "http://en.wikipedia.org/wiki/Boise,_Idaho",
                "http://en.wikipedia.org/wiki/Boise,_Idaho",
                "http://www.idaho.gov", "http://www.visitidaho.org", "geo:43.65,-116.25?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(13, "http://en.m.wikipedia.org/wiki/illinois",
                "http://en.wikipedia.org/wiki/Springfield,_Illinois",
                "http://en.wikipedia.org/wiki/Chicago",
                "http://www.illinois.gov", "http://www.enjoyillinois.com", "geo:39.79,-89.65?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(14, "http://en.m.wikipedia.org/wiki/indiana",
                "http://en.wikipedia.org/wiki/Indianapolis",
                "http://en.wikipedia.org/wiki/Indianapolis",
                "http://www.in.gov", "http://www.visitindiana.com", "geo:39.81,-86.26?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(15, "http://en.m.wikipedia.org/wiki/iowa",
                "http://en.wikipedia.org/wiki/Des_Moines,_Iowa",
                "http://en.wikipedia.org/wiki/Des_Moines,_Iowa",
                "http://www.iowa.gov", "http://www.traveliowa.com", "geo:42.15,-93.57?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(16, "http://en.m.wikipedia.org/wiki/kansas",
                "http://en.wikipedia.org/wiki/Topeka,_Kansas",
                "http://en.wikipedia.org/wiki/Wichita,_Kansas",
                "http://www.kansas.gov", "http://www.travelks.com", "geo:39.07,-95.68?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(17, "http://en.m.wikipedia.org/wiki/kentucky",
                "http://en.wikipedia.org/wiki/Frankfort,_Kentucky",
                "http://en.wikipedia.org/wiki/Louisville,_Kentucky",
                "http://www.kentucky.gov", "http://www.kentuckytourism.com", "geo:38.21,-84.87?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(18, "http://en.m.wikipedia.org/wiki/louisiana",
                "http://en.wikipedia.org/wiki/Baton_Rouge,_Louisiana",
                "http://en.wikipedia.org/wiki/New_Orleans",
                "http://www.louisiana.gov/", "http://www.louisianatravel.com", "geo:30.33,-92.15?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(19, "http://en.m.wikipedia.org/wiki/maine",
                "http://en.wikipedia.org/wiki/Augusta,_Maine",
                "http://en.wikipedia.org/wiki/Portland,_Maine",
                "http://www.maine.gov", "http://www.visitmaine.com", "geo:44.30,-69.78?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(20, "http://en.m.wikipedia.org/wiki/maryland",
                "http://en.wikipedia.org/wiki/Annapolis,_Maryland",
                "http://en.wikipedia.org/wiki/Baltimore",
                "http://www.maryland.gov", "http://www.visitmaryland.org", "geo:38.99,-76.49?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(21, "http://en.m.wikipedia.org/wiki/massachusetts",
                "http://en.wikipedia.org/wiki/Boston",
                "http://en.wikipedia.org/wiki/Boston",
                "http://www.mass.gov", "http://www.massvacation.com", "geo:42.35,-71.06?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(22, "http://en.m.wikipedia.org/wiki/michigan",
                "http://en.wikipedia.org/wiki/Lansing,_Michigan",
                "http://en.wikipedia.org/wiki/Detroit",
                "http://www.michigan.gov", "http://www.michigan.org", "geo:42.76,-84.57?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(23, "http://en.m.wikipedia.org/wiki/minnesota",
                "http://en.wikipedia.org/wiki/Saint_Paul,_Minnesota",
                "http://en.wikipedia.org/wiki/Minneapolis",
                "http://www.mn.gov", "http://www.exploreminnesota.com", "geo:46.94,-94.99?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(24, "http://en.m.wikipedia.org/wiki/mississippi",
                "http://en.wikipedia.org/wiki/Jackson,_Mississippi",
                "http://en.wikipedia.org/wiki/Jackson,_Mississippi",
                "http://www.ms.gov", "http://www.visitmississippi.org", "geo:32.35,-90.20?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(25, "http://en.m.wikipedia.org/wiki/missouri",
                "http://en.wikipedia.org/wiki/Jefferson_City,_Missouri",
                "http://en.wikipedia.org/wiki/Kansas_City,_Missouri",
                "http://www.mo.gov/", "http://www.visitmo.com", "geo:38.60,-92.20?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(26, "http://en.m.wikipedia.org/wiki/montana",
                "http://en.wikipedia.org/wiki/Helena,_Montana",
                "http://en.wikipedia.org/wiki/Billings,_Montana",
                "http://www.mt.gov", "http://www.visitmt.com", "geo:47.13,-110.05?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(27, "http://en.m.wikipedia.org/wiki/nebraska",
                "http://en.wikipedia.org/wiki/Lincoln,_Nebraska",
                "http://en.wikipedia.org/wiki/Omaha,_Nebraska",
                "http://www.nebraska.gov", "http://www.visitnebraska.org", "geo:41.79,-99.90?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(28, "http://en.m.wikipedia.org/wiki/nevada",
                "http://en.wikipedia.org/wiki/Carson_City,_Nevada",
                "http://en.wikipedia.org/wiki/Las_Vegas",
                "http://www.nv.gov", "http://www.nevadatourism.com", "geo:39.93,-117.48?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(29, "http://en.m.wikipedia.org/wiki/new_hampshire",
                "http://en.wikipedia.org/wiki/Concord,_New_Hampshire",
                "http://en.wikipedia.org/wiki/Manchester,_New_Hampshire",
                "http://www.nh.gov", "http://www.visitnh.gov", "geo:43.22,-71.55?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(30, "http://en.m.wikipedia.org/wiki/new_jersey",
                "http://en.wikipedia.org/wiki/Trenton,_New_Jersey",
                "http://en.wikipedia.org/wiki/Newark,_New_Jersey",
                "http://www.nj.gov", "http://www.visitnj.org", "geo:40.78,-73.99?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(31, "http://en.m.wikipedia.org/wiki/new_mexico",
                "http://en.wikipedia.org/wiki/Santa_Fe,_New_Mexico",
                "http://en.wikipedia.org/wiki/Albuquerque,_New_Mexico",
                "http://www.newmexico.gov", "http://www.newmexico.org", "geo:35.86,-105.98?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(32, "http://en.m.wikipedia.org/wiki/new_york",
                "http://en.wikipedia.org/wiki/Albany,_New_York",
                "http://en.wikipedia.org/wiki/New_York_City",
                "http://www.ny.gov", "http://www.newyork.com", "geo:40.79,-73.95?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(33, "http://en.m.wikipedia.org/wiki/north_carolina",
                "http://en.wikipedia.org/wiki/Raleigh,_North_Carolina",
                "http://en.wikipedia.org/wiki/Charlotte,_North_Carolina",
                "http://www.nc.gov", "http://www.visitnc.com", "geo:35.81,-78.65?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(34, "http://en.m.wikipedia.org/wiki/north_dakota",
                "http://en.wikipedia.org/wiki/Bismarck,_North_Dakota",
                "http://en.wikipedia.org/wiki/Fargo,_North_Dakota",
                "http://www.nd.gov", "http://www.ndtourism.com", "geo:47.46,-100.67?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(35, "http://en.m.wikipedia.org/wiki/ohio",
                "http://en.wikipedia.org/wiki/Columbus,_Ohio",
                "http://en.wikipedia.org/wiki/Columbus,_Ohio",
                "http://www.ohio.gov", "http://consumer.discoverohio.com", "geo:39.97,-83.02?z=8"));
        databaseHelper.addWebRecord(new StateWebLinks(36, "http://en.m.wikipedia.org/wiki/oklahoma",
                "http://en.wikipedia.org/wiki/Oklahoma_City",
                "http://en.wikipedia.org/wiki/Oklahoma_City",
                "http://www.ok.gov", "http://www.travelok.com", "geo:35.53,-97.58?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(37, "http://en.m.wikipedia.org/wiki/oregon",
                "http://en.wikipedia.org/wiki/Salem,_Oregon",
                "http://en.wikipedia.org/wiki/Portland,_Oregon",
                "http://www.oregon.gov", "http://www.traveloregon.com", "geo:44.33,-121.06?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(38, "http://en.m.wikipedia.org/wiki/pennsylvania",
                "http://en.wikipedia.org/wiki/Harrisburg,_Pennsylvania",
                "http://en.wikipedia.org/wiki/Philadelphia",
                "http://www.pa.gov", "http://www.visitpa.com", "geo:41.01,-77.84?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(39, "http://en.m.wikipedia.org/wiki/rhode_island",
                "http://en.wikipedia.org/wiki/Providence,_Rhode_Island",
                "http://en.wikipedia.org/wiki/Providence,_Rhode_Island",
                "http://www.ri.gov", "http://www.visitrhodeisland.com", "geo:41.83,-71.40?z=8"));
        databaseHelper.addWebRecord(new StateWebLinks(40, "http://en.m.wikipedia.org/wiki/south_carolina",
                "http://en.wikipedia.org/wiki/Columbia,_South_Carolina",
                "http://en.wikipedia.org/wiki/Columbia,_South_Carolina",
                "http://www.sc.gov", "http://www.discoversouthcarolina.com", "geo:34.05,-81.03?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(41, "http://en.m.wikipedia.org/wiki/south_dakota",
                "http://en.wikipedia.org/wiki/Pierre,_South_Dakota",
                "http://en.wikipedia.org/wiki/Sioux_Falls,_South_Dakota",
                "http://www.sd.gov", "http://www.travelsd.com", "geo:44.39,-100.35?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(42, "http://en.m.wikipedia.org/wiki/tennessee",
                "http://en.wikipedia.org/wiki/Nashville,_Tennessee",
                "http://en.wikipedia.org/wiki/Memphis,_Tennessee",
                "http://www.tennessee.gov", "http://www.tnvacation.com", "geo:36.26,-86.82?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(43, "http://en.m.wikipedia.org/wiki/texas",
                "http://en.wikipedia.org/wiki/Austin,_Texas",
                "http://en.wikipedia.org/wiki/Houston",
                "http://www.texas.gov", "http://www.traveltex.com", "geo:30.42,-97.79?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(44, "http://en.m.wikipedia.org/wiki/utah",
                "http://en.wikipedia.org/wiki/Salt_Lake_City",
                "http://en.wikipedia.org/wiki/Salt_Lake_City",
                "http://www.utah.gov", "http://www.visitutah.com", "geo:40.76,-111.90?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(45, "http://en.m.wikipedia.org/wiki/vermont",
                "http://en.wikipedia.org/wiki/Montpelier,_Vermont",
                "http://en.wikipedia.org/wiki/Burlington,_Vermont",
                "http://www.vermont.gov", "http://www.vermontvacation.com", "geo:44.29,-72.58?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(46, "http://en.m.wikipedia.org/wiki/virginia",
                "http://en.wikipedia.org/wiki/Richmond,_Virginia",
                "http://en.wikipedia.org/wiki/Virginia_Beach,_Virginia",
                "http://www.virginia.gov", "http://www.virginia.org", "geo:37.49,-77.43?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(47, "http://en.m.wikipedia.org/wiki/washington",
                "http://en.wikipedia.org/wiki/Olympia,_Washington",
                "http://en.wikipedia.org/wiki/Seattle",
                "http://www.access.wa.gov", "http://www.experiencewa.com", "geo:47.05,-122.91?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(48, "http://en.m.wikipedia.org/wiki/west_virginia",
                "http://en.wikipedia.org/wiki/Charleston,_West_Virginia",
                "http://en.wikipedia.org/wiki/Charleston,_West_Virginia",
                "http://www.wv.gov", "http://www.wvtourism.com", "geo:38.38,-81.65?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(49, "http://en.m.wikipedia.org/wiki/wisconsin",
                "http://en.wikipedia.org/wiki/Madison,_Wisconsin",
                "http://en.wikipedia.org/wiki/Milwaukee",
                "http://www.wisconsin.gov", "http://www.travelwisconsin.com", "geo:44.96,-89.98?z=7"));
        databaseHelper.addWebRecord(new StateWebLinks(50, "http://en.m.wikipedia.org/wiki/wyoming",
                "http://en.wikipedia.org/wiki/Cheyenne,_Wyoming",
                "http://en.wikipedia.org/wiki/Cheyenne,_Wyoming",
                "http://www.wyoming.gov", "http://www.wyomingtourism.org", "geo:43.56,-107.59?z=7"));

        return databaseHelper;
    }

    public void onResume()
    {
        super.onResume();
    }
}
