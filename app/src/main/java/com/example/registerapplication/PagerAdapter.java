package com.example.registerapplication;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    final int pageCount =3;
    private String tabTitle [] = new String[]{"HOW IT WORKS  " ,"FIND A DOCTOR", "FAQ" };
    //private String tabImage [] = new String[]{"howorks64.png","faq64.png","findadoctor64.png" };

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm ,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new FirstFragment();
            case 1:
                return new SecondFragment();
            case 2:
                return new ThirdFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageCount;
    }
    @NonNull
    @Override
    public CharSequence getPageTitle(int position)
    {
        return tabTitle[position];
    }
}
