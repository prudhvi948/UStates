package com.ustates.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;


/**
 * Created by prudhvi on 5/25/2014.
 */
public class StatePageFragmentAdapter extends FragmentPagerAdapter{

    private static final int PAGE_COUNT = 50;

    public StatePageFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        StatePageFragment statePageFragment = new StatePageFragment();
        Bundle data = new Bundle();
        data.putInt("Page Number", position + 1);
        statePageFragment.setArguments(data);
        return statePageFragment;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MainPageAdapter.alist.get(position);
    }
}
