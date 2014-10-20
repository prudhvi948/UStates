package com.example.unitedstates.app;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;



/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link StatePageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link StatePageFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class StatePageFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private int pageNumber;
    private String mapLocation, stateWiki, capitalWiki, largestCityWiki, stateWeb, tourismWeb;
    private ImageView imageView1;
    private TextView textView1, textView2, textView3, textView4, textView5,
            textView6, textView7, textView8, textView9, textView10, textView11,
            textView12, textView13, textView14, textView15;
    private StateIndex s1;
    private StateWebLinks s2;
    MainPage mainPage;
    UnitedStatesDatabaseHelper u;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment StatePageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static StatePageFragment newInstance(String param1, String param2) {
        StatePageFragment fragment = new StatePageFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public StatePageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Bundle data = getArguments();
        pageNumber = data.getInt("Page Number", 1);
    }

    /* Method to set data in the StatePage's views by retrieving data from the DB*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.state_info, container,false);
        imageView1 = (ImageView)view.findViewById(R.id.state_flag);
        textView1 = (TextView)view.findViewById(R.id.state_name_info);
        textView2 = (TextView)view.findViewById(R.id.abbreviation_info);
        textView3 = (TextView)view.findViewById(R.id.nickname_info);
        textView4 = (TextView)view.findViewById(R.id.demonym_info);
        textView5 = (TextView)view.findViewById(R.id.capital_info);
        textView6 = (TextView)view.findViewById(R.id.largest_city_info);
        textView7 = (TextView)view.findViewById(R.id.area_info);
        textView8 = (TextView)view.findViewById(R.id.area_rank_info);
        textView9 = (TextView)view.findViewById(R.id.population_info);
        textView10 = (TextView)view.findViewById(R.id.population_rank_info);
        textView11 = (TextView)view.findViewById(R.id.year_info);
        textView12 = (TextView)view.findViewById(R.id.timezone_info);
        textView13 = (TextView)view.findViewById(R.id.website_info);
        textView14 = (TextView)view.findViewById(R.id.tourism_info);
        textView15 = (TextView)view.findViewById(R.id.map);

        s1 = new StateIndex();
        s2 = new StateWebLinks();
        mainPage = new MainPage();
        u = mainPage.createDatabase();

        switch(pageNumber)
        {
            case 1:
                s1 = u.getStateInfo(1);
                selectState(1);
                imageView1.setImageResource(R.drawable.alabama);
                break;
            case 2:
                s1 = u.getStateInfo(2);
                selectState(2);
                imageView1.setImageResource(R.drawable.alaska);
                break;
            case 3:
                s1 = u.getStateInfo(3);
                selectState(3);
                imageView1.setImageResource(R.drawable.arizona);
                break;
            case 4:
                s1 = u.getStateInfo(4);
                selectState(4);
                imageView1.setImageResource(R.drawable.arkansas);
                break;
            case 5:
                s1 = u.getStateInfo(5);
                selectState(5);
                imageView1.setImageResource(R.drawable.california);
                break;
            case 6:
                s1 = u.getStateInfo(6);
                selectState(6);
                imageView1.setImageResource(R.drawable.colorado);
                break;
            case 7:
                s1 = u.getStateInfo(7);
                selectState(7);
                imageView1.setImageResource(R.drawable.connecticut);
                break;
            case 8:
                s1 = u.getStateInfo(8);
                selectState(8);
                imageView1.setImageResource(R.drawable.delaware);
                break;
            case 9:
                s1 = u.getStateInfo(9);
                selectState(9);
                imageView1.setImageResource(R.drawable.florida);
                break;
            case 10:
                s1 = u.getStateInfo(10);
                selectState(10);
                imageView1.setImageResource(R.drawable.georgia);
                break;
            case 11:
                s1 = u.getStateInfo(11);
                selectState(11);
                imageView1.setImageResource(R.drawable.hawaii);
                break;
            case 12:
                s1 = u.getStateInfo(12);
                selectState(12);
                imageView1.setImageResource(R.drawable.idaho);
                break;
            case 13:
                s1 = u.getStateInfo(13);
                selectState(13);
                imageView1.setImageResource(R.drawable.illinois);
                break;
            case 14:
                s1 = u.getStateInfo(14);
                selectState(14);
                imageView1.setImageResource(R.drawable.indiana);
                break;
            case 15:
                s1 = u.getStateInfo(15);
                selectState(15);
                imageView1.setImageResource(R.drawable.iowa);
                break;
            case 16:
                s1 = u.getStateInfo(16);
                selectState(16);
                imageView1.setImageResource(R.drawable.kansas);
                break;
            case 17:
                s1 = u.getStateInfo(17);
                selectState(17);
                imageView1.setImageResource(R.drawable.kentucky);
                break;
            case 18:
                s1 = u.getStateInfo(18);
                selectState(18);
                imageView1.setImageResource(R.drawable.louisiana);
                break;
            case 19:
                s1 = u.getStateInfo(19);
                selectState(19);
                imageView1.setImageResource(R.drawable.maine);
                break;
            case 20:
                s1 = u.getStateInfo(20);
                selectState(20);
                imageView1.setImageResource(R.drawable.maryland);
                break;
            case 21:
                s1 = u.getStateInfo(21);
                selectState(21);
                imageView1.setImageResource(R.drawable.massachusetts);
                break;
            case 22:
                s1 = u.getStateInfo(22);
                selectState(22);
                imageView1.setImageResource(R.drawable.michigan);
                break;
            case 23:
                s1 = u.getStateInfo(23);
                selectState(23);
                imageView1.setImageResource(R.drawable.minnesota);
                break;
            case 24:
                s1 = u.getStateInfo(24);
                selectState(24);
                imageView1.setImageResource(R.drawable.mississippi);
                break;
            case 25:
                s1 = u.getStateInfo(25);
                selectState(25);
                imageView1.setImageResource(R.drawable.missouri);
                break;
            case 26:
                s1 = u.getStateInfo(26);
                selectState(26);
                imageView1.setImageResource(R.drawable.montana);
                break;
            case 27:
                s1 = u.getStateInfo(27);
                selectState(27);
                imageView1.setImageResource(R.drawable.nebraska);
                break;
            case 28:
                s1 = u.getStateInfo(28);
                selectState(28);
                imageView1.setImageResource(R.drawable.nevada);
                break;
            case 29:
                s1 = u.getStateInfo(29);
                selectState(29);
                imageView1.setImageResource(R.drawable.new_hampshire);
                break;
            case 30:
                s1 = u.getStateInfo(30);
                selectState(30);
                imageView1.setImageResource(R.drawable.new_jersey);
                break;
            case 31:
                s1 = u.getStateInfo(31);
                selectState(31);
                imageView1.setImageResource(R.drawable.new_mexico);
                break;
            case 32:
                s1 = u.getStateInfo(32);
                selectState(32);
                imageView1.setImageResource(R.drawable.new_york);
                break;
            case 33:
                s1 = u.getStateInfo(33);
                selectState(33);
                imageView1.setImageResource(R.drawable.north_carolina);
                break;
            case 34:
                s1 = u.getStateInfo(34);
                selectState(34);
                imageView1.setImageResource(R.drawable.north_dakota);
                break;
            case 35:
                s1 = u.getStateInfo(35);
                selectState(35);
                imageView1.setImageResource(R.drawable.ohio);
                break;
            case 36:
                s1 = u.getStateInfo(36);
                selectState(36);
                imageView1.setImageResource(R.drawable.oklahoma);
                break;
            case 37:
                s1 = u.getStateInfo(37);
                selectState(37);
                imageView1.setImageResource(R.drawable.oregon);
                break;
            case 38:
                s1 = u.getStateInfo(38);
                selectState(38);
                imageView1.setImageResource(R.drawable.pennsylvania);
                break;
            case 39:
                s1 = u.getStateInfo(39);
                selectState(39);
                imageView1.setImageResource(R.drawable.rhode_island);
                break;
            case 40:
                s1 = u.getStateInfo(40);
                selectState(40);
                imageView1.setImageResource(R.drawable.south_carolina);
                break;
            case 41:
                s1 = u.getStateInfo(41);
                selectState(41);
                imageView1.setImageResource(R.drawable.south_dakota);
                break;
            case 42:
                s1 = u.getStateInfo(42);
                selectState(42);
                imageView1.setImageResource(R.drawable.tennessee);
                break;
            case 43:
                s1 = u.getStateInfo(43);
                selectState(43);
                imageView1.setImageResource(R.drawable.texas);
                break;
            case 44:
                s1 = u.getStateInfo(44);
                selectState(44);
                imageView1.setImageResource(R.drawable.utah);
                break;
            case 45:
                s1 = u.getStateInfo(45);
                selectState(45);
                imageView1.setImageResource(R.drawable.vermont);
                break;
            case 46:
                s1 = u.getStateInfo(46);
                selectState(46);
                imageView1.setImageResource(R.drawable.virginia);
                break;
            case 47:
                s1 = u.getStateInfo(47);
                selectState(47);
                imageView1.setImageResource(R.drawable.washington);
                break;
            case 48:
                s1 = u.getStateInfo(48);
                selectState(48);
                imageView1.setImageResource(R.drawable.west_virginia);
                break;
            case 49:
                s1 = u.getStateInfo(49);
                selectState(49);
                imageView1.setImageResource(R.drawable.wisconsin);
                break;
            default:
                s1 = u.getStateInfo(50);
                selectState(50);
                imageView1.setImageResource(R.drawable.wyoming);
        }
        textView1.setPaintFlags(textView1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView1.setText(s1.getName());
        textView2.setText(s1.getAbbreviation());
        textView3.setText(s1.getNickname());
        textView4.setText(s1.getDemonym());
        if(s1.getCapital().equals(s1.getLargestCity()))
        {
            textView5.setPaintFlags(textView5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }
        else
        {
            textView5.setPaintFlags(textView5.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
            textView6.setPaintFlags(textView6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }
        textView5.setText(s1.getCapital());
        textView6.setText(s1.getLargestCity());
        textView7.setText(s1.getArea());
        textView8.setText(s1.getAreaRank());
        textView9.setText(s1.getPopulation());
        textView10.setText(s1.getPopulationRank());
        textView11.setText(s1.getYear());
        textView12.setText(s1.getTimezone());
        textView13.setPaintFlags(textView6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView13.setText(s1.getWebsite());
        textView14.setPaintFlags(textView6.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView14.setText(s1.getTourism());
        textView1.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(stateWiki));
                startActivity(intent);
            }
        });
        textView5.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(capitalWiki));
                startActivity(intent);
            }
        });
        textView6.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(largestCityWiki));
                startActivity(intent);
            }
        });
        textView13.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(stateWeb));
                startActivity(intent);
            }
        });
        textView14.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(tourismWeb));
                startActivity(intent);
            }
        });
        textView15.setOnClickListener(new TextView.OnClickListener(){
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapLocation));
                startActivity(intent);
            }
        });
        return view;
    }

    /* Method to set appropriate state details to each state*/
    public void selectState(int i)
    {
        s2 = u.getWebLinks(i);
        stateWiki = s2.getStateWiki();
        capitalWiki = s2.getCapitalWiki();
        largestCityWiki = s2.getLargestCityWiki();
        stateWeb = s2.getStateWeb();
        tourismWeb = s2.getTourismWeb();
        mapLocation = s2.getMapLocation();
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
