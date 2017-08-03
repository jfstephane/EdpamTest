package jfsl.edpam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager;

import jfsl.edpam.Fragments.InfoFragment;
import jfsl.edpam.Fragments.PictureFragment;


public class MainActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener{


    private AHBottomNavigationViewPager viewPager;
    AHBottomNavigation bottomNavigation;
    PictureFragment pictureFragment;
    ListFragment listFragment;
    InfoFragment infoFragment;
    FragmentPagerAdapter adapterViewPager;


    //PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);







            //pictureFragment = (PictureFragment) getSupportFragmentManager().findFragmentById(R.id.fragment);




        bottomNavigation = (AHBottomNavigation) findViewById(R.id.BottomNavBar);
        viewPager = (AHBottomNavigationViewPager) findViewById(R.id.view_pager);
        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapterViewPager);
        //bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();




        //fragmentManager.beginTransaction().replace(R.id.mother, fragment).commit();



    }

    private void createNavItems() {

        AHBottomNavigationItem pictureItem = new AHBottomNavigationItem("Signaler", R.drawable.camera);
        AHBottomNavigationItem listItem = new AHBottomNavigationItem("List", R.drawable.list);
        AHBottomNavigationItem infoItem = new AHBottomNavigationItem("Info", R.drawable.info2);

        bottomNavigation.addItem(pictureItem);
        bottomNavigation.addItem(listItem);
        bottomNavigation.addItem(infoItem);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FFFFFF"));

        bottomNavigation.setCurrentItem(0);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {


        FragmentManager fragmentManager = null;
        if (position == 0) {
            //PictureFragment pictureFragment = new PictureFragment();
            fragmentManager.beginTransaction().replace(R.id.mother, pictureFragment).commit();

        } else if (position == 1) {
            //ListFragment listFragment = new ListFragment();
            fragmentManager.beginTransaction().replace(R.id.mother, listFragment).commit();
        } else if (position == 2) {
            //InfoFragment infoFragment = new InfoFragment();
            fragmentManager.beginTransaction().replace(R.id.mother, infoFragment).commit();
        }





        return false;
    }


    public class MyPagerAdapter extends FragmentPagerAdapter {
        private int NUM_ITEMS = 3;
        //private AHBottomNavigation bottomNavigation;

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return NUM_ITEMS;
        }

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            Log.d("DEBUG", String.valueOf(position));
            switch (position) {
                case 0: // Fragment # 0 - This will show FirstFragment
                    return new PictureFragment();
                case 1: // Fragment # 0 - This will show FirstFragment different title
                    return new ListFragment();
                case 2: // Fragment # 1 - This will show SecondFragment
                    return new InfoFragment();
                default:
                    return null;
            }
        }




        /*private void createNavItems() {
            AHBottomNavigationItem pictureItem = new AHBottomNavigationItem("Signaler", R.drawable.camera);
            AHBottomNavigationItem listItem = new AHBottomNavigationItem("List", R.drawable.list);
            AHBottomNavigationItem infoItem = new AHBottomNavigationItem("Info", R.drawable.info2);

            bottomNavigation.addItem(pictureItem);
            bottomNavigation.addItem(listItem);
            bottomNavigation.addItem(infoItem);

            bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FFFFFF"));

            bottomNavigation.setCurrentItem(0);*/










       /* @Override
        public boolean onTabSelected (int position, boolean wasSelected){
            Log.d("DEBUG", String.valueOf(position));


                FragmentManager fragmentManager = null;
                if (position == 0) {
                //PictureFragment pictureFragment = new PictureFragment();
                fragmentManager.beginTransaction().replace(R.id.fragment, pictureFragment).commit();

            } else if (position == 1) {
                //ListFragment listFragment = new ListFragment();
                fragmentManager.beginTransaction().replace(R.id.fragment, listFragment).commit();
            } else if (position == 2) {
                //InfoFragment infoFragment = new InfoFragment();
                fragmentManager.beginTransaction().replace(R.id.fragment, infoFragment).commit();
            }

            //viewPager.setCurrentItem(position, false);
            //fragment.willBeDisplayed();

            return true;

        }*/




    /*bottomNavigation.setOnNavigationPositionListener(new AHBottomNavigation.OnNavigationPositionListener() {
        @Override public void onPositionChange(int y) {
            Log.d("MainActivity", "BottomNavigation Position: " + y);
        }*/





}
}

