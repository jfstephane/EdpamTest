package jfsl.edpam;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;

import jfsl.edpam.Fragments.InfoFragment;
import jfsl.edpam.Fragments.PictureFragment;

/**
 * Created by kayla2 on 9/4/2016.
 */
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Signaler", "List", "Info" };
    private Context context;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }



    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment =null;
        switch (position) {
            case 0:
                fragment = new PictureFragment();
                break;
            case 1:
                fragment = new ListFragment();
                break;
            case 2:
                fragment = new InfoFragment();
                break;          }
        return fragment;
        //return PageFragment.newInstance(position + 1);


    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

}
