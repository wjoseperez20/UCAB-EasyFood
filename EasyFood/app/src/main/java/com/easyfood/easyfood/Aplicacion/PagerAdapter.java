package com.easyfood.easyfood.Aplicacion;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.easyfood.easyfood.AlmuerzoFragment;
import com.easyfood.easyfood.DesayunoFragment;
import com.easyfood.easyfood.PostreFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new DesayunoFragment();
            case 1:
                return new AlmuerzoFragment();
            case 2:
                return new PostreFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}