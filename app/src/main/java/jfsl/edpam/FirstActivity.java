package jfsl.edpam;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;

import jfsl.edpam.Fragments.InfoFragment;
import jfsl.edpam.Fragments.PictureFragment;

public class FirstActivity extends AppCompatActivity implements AHBottomNavigation.OnTabSelectedListener {

    AHBottomNavigation bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        bottomNavigation = (AHBottomNavigation)findViewById(R.id.BottomNavBar);
        bottomNavigation.setOnTabSelectedListener(this);
        this.createNavItems();


    }

    private void createNavItems()
    {
        AHBottomNavigationItem pictureItem = new AHBottomNavigationItem("Signaler", R.drawable.camera);
        AHBottomNavigationItem listItem = new AHBottomNavigationItem("Signaler", R.drawable.list);
        AHBottomNavigationItem infoItem = new AHBottomNavigationItem("Signaler", R.drawable.info2);

        bottomNavigation.addItem(pictureItem);
        bottomNavigation.addItem(listItem);
        bottomNavigation.addItem(infoItem);

        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FFFFFF"));

        bottomNavigation.setCurrentItem(0);
    }

    @Override
    public boolean onTabSelected(int position, boolean wasSelected) {
        if (position == 0) {
            PictureFragment pictureFragment = new PictureFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mother, pictureFragment).commit();
        } /*else if (position == 1) {
            ListFragment listFragment = new ListFragment();
            getFragmentManager().beginTransaction().replace(R.id.mother, ListFragment).commit();
        }*/ else if (position == 1) {
            InfoFragment infoFragment = new InfoFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.mother, infoFragment).commit();
        }
        return true;



    }




}
