package com.ustates.app;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * Created by prudhvi on 5/21/2014.
 */
public class MainPageAdapter extends BaseAdapter implements Filterable {
    public static ArrayList<String> alist = new ArrayList<String>();
    private QueryFilter queryFilter;
    ArrayList<String> temp;
    ArrayList<String> filterStateList;

    /* Storing the data behind the ListView in an ArrayList*/
    public MainPageAdapter()
    {
        alist.add("Alabama");
        alist.add("Alaska");
        alist.add("Arizona");
        alist.add("Arkansas");
        alist.add("California");
        alist.add("Colorado");
        alist.add("Connecticut");
        alist.add("Delaware");
        alist.add("Florida");
        alist.add("Georgia");
        alist.add("Hawaii");
        alist.add("Idaho");
        alist.add("Illinois");
        alist.add("Indiana");
        alist.add("Iowa");
        alist.add("Kansas");
        alist.add("Kentucky");
        alist.add("Louisiana");
        alist.add("Maine");
        alist.add("Maryland");
        alist.add("Massachusetts");
        alist.add("Michigan");
        alist.add("Minnesota");
        alist.add("Mississippi");
        alist.add("Missouri");
        alist.add("Montana");
        alist.add("Nebraska");
        alist.add("Nevada");
        alist.add("New Hampshire");
        alist.add("New Jersey");
        alist.add("New Mexico");
        alist.add("New York");
        alist.add("North Carolina");
        alist.add("North Dakota");
        alist.add("Ohio");
        alist.add("Oklahoma");
        alist.add("Oregon");
        alist.add("Pennsylvania");
        alist.add("Rhode Island");
        alist.add("South Carolina");
        alist.add("South Dakota");
        alist.add("Tennessee");
        alist.add("Texas");
        alist.add("Utah");
        alist.add("Vermont");
        alist.add("Virginia");
        alist.add("Washington");
        alist.add("West Virginia");
        alist.add("Wisconsin");
        alist.add("Wyoming");
        temp = alist;
    }

    @Override
    public int getCount() {
        return alist.size();
    }

    @Override
    public Object getItem(int i) {
        if(alist != null){
            return alist.get(i);
        }
        else{
            return null;
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public boolean hasStableIds()
    {
        return true;
    }

    /* Method that builds the graphical ListView by using the data in the ArrayList*/
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null)
        {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.state_list, viewGroup, false);
        }
        String state = alist.get(i);
        TextView stateTextView = (TextView)view.findViewById(R.id.state_view);
        stateTextView.setText(state);
        ImageView imageView = (ImageView)view.findViewById(R.id.flag_view);
        switch(state)
        {
            case "Alabama":
                imageView.setImageResource(R.drawable.alabama);
                break;
            case "Alaska":
                imageView.setImageResource(R.drawable.alaska);
                break;
            case "Arizona":
                imageView.setImageResource(R.drawable.arizona);
                break;
            case "Arkansas":
                imageView.setImageResource(R.drawable.arkansas);
                break;
            case "California":
                imageView.setImageResource(R.drawable.california);
                break;
            case "Colorado":
                imageView.setImageResource(R.drawable.colorado);
                break;
            case "Connecticut":
                imageView.setImageResource(R.drawable.connecticut);
                break;
            case "Delaware":
                imageView.setImageResource(R.drawable.delaware);
                break;
            case "Florida":
                imageView.setImageResource(R.drawable.florida);
                break;
            case "Georgia":
                imageView.setImageResource(R.drawable.georgia);
                break;
            case "Hawaii":
                imageView.setImageResource(R.drawable.hawaii);
                break;
            case "Idaho":
                imageView.setImageResource(R.drawable.idaho);
                break;
            case "Illinois":
                imageView.setImageResource(R.drawable.illinois);
                break;
            case "Indiana":
                imageView.setImageResource(R.drawable.indiana);
                break;
            case "Iowa":
                imageView.setImageResource(R.drawable.iowa);
                break;
            case "Kansas":
                imageView.setImageResource(R.drawable.kansas);
                break;
            case "Kentucky":
                imageView.setImageResource(R.drawable.kentucky);
                break;
            case "Louisiana":
                imageView.setImageResource(R.drawable.louisiana);
                break;
            case "Maine":
                imageView.setImageResource(R.drawable.maine);
                break;
            case "Maryland":
                imageView.setImageResource(R.drawable.maryland);
                break;
            case "Massachusetts":
                imageView.setImageResource(R.drawable.massachusetts);
                break;
            case "Michigan":
                imageView.setImageResource(R.drawable.michigan);
                break;
            case "Minnesota":
                imageView.setImageResource(R.drawable.minnesota);
                break;
            case "Mississippi":
                imageView.setImageResource(R.drawable.mississippi);
                break;
            case "Missouri":
                imageView.setImageResource(R.drawable.missouri);
                break;
            case "Montana":
                imageView.setImageResource(R.drawable.montana);
                break;
            case "Nebraska":
                imageView.setImageResource(R.drawable.nebraska);
                break;
            case "Nevada":
                imageView.setImageResource(R.drawable.nevada);
                break;
            case "New Hampshire":
                imageView.setImageResource(R.drawable.new_hampshire);
                break;
            case "New Jersey":
                imageView.setImageResource(R.drawable.new_jersey);
                break;
            case "New Mexico":
                imageView.setImageResource(R.drawable.new_mexico);
                break;
            case "New York":
                imageView.setImageResource(R.drawable.new_york);
                break;
            case "North Carolina":
                imageView.setImageResource(R.drawable.north_carolina);
                break;
            case "North Dakota":
                imageView.setImageResource(R.drawable.north_dakota);
                break;
            case "Ohio":
                imageView.setImageResource(R.drawable.ohio);
                break;
            case "Oklahoma":
                imageView.setImageResource(R.drawable.oklahoma);
                break;
            case "Oregon":
                imageView.setImageResource(R.drawable.oregon);
                break;
            case "Pennsylvania":
                imageView.setImageResource(R.drawable.pennsylvania);
                break;
            case "Rhode Island":
                imageView.setImageResource(R.drawable.rhode_island);
                break;
            case "South Carolina":
                imageView.setImageResource(R.drawable.south_carolina);
                break;
            case "South Dakota":
                imageView.setImageResource(R.drawable.south_dakota);
                break;
            case "Tennessee":
                imageView.setImageResource(R.drawable.tennessee);
                break;
            case "Texas":
                imageView.setImageResource(R.drawable.texas);
                break;
            case "Utah":
                imageView.setImageResource(R.drawable.utah);
                break;
            case "Vermont":
                imageView.setImageResource(R.drawable.vermont);
                break;
            case "Virginia":
                imageView.setImageResource(R.drawable.virginia);
                break;
            case "Washington":
                imageView.setImageResource(R.drawable.washington);
                break;
            case "West Virginia":
                imageView.setImageResource(R.drawable.west_virginia);
                break;
            case "Wisconsin":
                imageView.setImageResource(R.drawable.wisconsin);
                break;
            case "Wyoming":
                imageView.setImageResource(R.drawable.wyoming);
                break;
            default:
        }
        return view;
    }

    @Override
    public Filter getFilter() {
        if(queryFilter == null){
            queryFilter =  new QueryFilter();
        }
        return queryFilter;
    }

    /* Filtering the ListView according to the search functionality is done in this class */
    private class QueryFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            if(charSequence!= null && charSequence.length()>= 0)
            {
                filterStateList = new ArrayList<String>();
                for(int i=0; i< temp.size(); i++)
                {
                    if((temp.get(i).toLowerCase().contains(charSequence.toString().toLowerCase())))
                    {
                        filterStateList.add(temp.get(i));
                    }
                    else
                    {

                    }
                }
                filterResults.count = filterStateList.size();
                filterResults.values = filterStateList;
            }
            else
            {
                filterResults.count = alist.size();
                filterResults.values = alist;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            alist = (ArrayList<String>) filterResults.values;
            notifyDataSetChanged();
        }
    }
}
