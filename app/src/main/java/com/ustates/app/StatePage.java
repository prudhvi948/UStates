package com.ustates.app;

import android.app.ActionBar;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.ImageView;


public class StatePage extends FragmentActivity implements StatePageFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_state_page);
        ActionBar actionBar = getActionBar();
        actionBar.setIcon(R.drawable.ic_launcher);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        FragmentManager fragmentManager = getSupportFragmentManager();
        StatePageFragmentAdapter statePageFragmentAdapter = new StatePageFragmentAdapter(fragmentManager);
        viewPager.setAdapter(statePageFragmentAdapter);
        Intent startIntent = getIntent();
        int pageNumber = startIntent.getIntExtra("page number", 0);
        viewPager.setCurrentItem(pageNumber);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.state_page, menu);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
