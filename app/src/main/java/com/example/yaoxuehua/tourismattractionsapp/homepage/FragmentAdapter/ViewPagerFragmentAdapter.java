package com.example.yaoxuehua.tourismattractionsapp.homepage.FragmentAdapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by yaoxuehua on 16-11-29.
 */

public class ViewPagerFragmentAdapter extends FragmentPagerAdapter{
    private List<Fragment> mFragments;

    public ViewPagerFragmentAdapter(FragmentManager fm, List<Fragment> list_fragment) {
        super(fm);
        this.mFragments = list_fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }
}
