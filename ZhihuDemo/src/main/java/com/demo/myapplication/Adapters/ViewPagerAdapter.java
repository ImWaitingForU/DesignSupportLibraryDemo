package com.demo.myapplication.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import java.util.List;

/**
 * ShouyeFragmentViewPager的Adapter
 */
public class ViewPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;
    private List<String> titleList;

    public ViewPagerAdapter (FragmentManager fm,List<Fragment> fragmentList,List<String> titleList) {
        super (fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public Fragment getItem (int position) {
        return fragmentList.get (position);
    }

    @Override
    public int getCount () {
        return fragmentList.size ();
    }

    @Override
    public CharSequence getPageTitle (int position) {
        return titleList.get (position%titleList.size ());
    }
}
