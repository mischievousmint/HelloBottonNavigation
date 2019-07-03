package com.example.hellobottonnavigation;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.hellobottonnavigation.Fragments.DashboardFragment;
import com.example.hellobottonnavigation.Fragments.HomeFragment;
import com.example.hellobottonnavigation.Fragments.NotificationsFragment;

public class MainActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener, DashboardFragment.OnFragmentInteractionListener, NotificationsFragment.OnFragmentInteractionListener{
    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    launchFragment(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    launchFragment(new DashboardFragment());
                    return true;
                case R.id.navigation_notifications:
                    launchFragment(new NotificationsFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        launchFragment(new HomeFragment());
    }

    private void launchFragment(Fragment newfragment) {
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        FT.replace(R.id.flContainer,newfragment);
        FT.addToBackStack(null);
        FT.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
