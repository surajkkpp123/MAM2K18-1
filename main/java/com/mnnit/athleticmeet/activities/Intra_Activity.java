package com.mnnit.athleticmeet.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.mnnit.athleticmeet.adapters.PagerAdapter2;
import com.mnnit.athleticmeet.R;
import com.mnnit.athleticmeet.fragments.Fragmentra1;
import com.mnnit.athleticmeet.fragments.Fragmentra2;
import com.mnnit.athleticmeet.fragments.Fragmentra3;

public class Intra_Activity extends AppCompatActivity implements Fragmentra1.OnFragmentInteractionListener,Fragmentra2.OnFragmentInteractionListener,Fragmentra3.OnFragmentInteractionListener{
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private View navHeader;
    private ImageView imgNavHeaderBg, imgProfile;
    private TextView txtName, txtWebsite;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private String[] activityTitles;
    private Handler mHandler;
    private ImageButton imageButton;
    // index to identify current nav menu item
    public static int navItemIndex = 0;

    // tags used to attach the intent
    @Override
    protected void onPostResume() {
        super.onPostResume();
        MenuItem mn;
        mn=navigationView.getMenu().getItem(2);
        mn.setChecked(true);

    }
    @Override
    public boolean onNavigateUp(){
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//For FullScreen
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intra_);
        toolbar = (Toolbar) findViewById(R.id.toolbar4);
        TabLayout tabLayout=(TabLayout)findViewById(R.id.tablayout4);
        tabLayout.addTab(tabLayout.newTab().setText("Feb 8,2018"));
        tabLayout.addTab(tabLayout.newTab().setText("Feb 9,2018"));
        tabLayout.addTab(tabLayout.newTab().setText("Feb 10,2018"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager=(ViewPager)findViewById(R.id.pager4);
        final PagerAdapter2 adapter3=new PagerAdapter2(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter3);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        setSupportActionBar(toolbar);
        mHandler = new Handler();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        // Navigation view header
        navHeader = navigationView.getHeaderView(0);
        imgNavHeaderBg = (ImageView) navHeader.findViewById(R.id.img_header_bg);
        // load toolbar titles from string resources
        activityTitles = getResources().getStringArray(R.array.nav_item_activity_titles);
        MenuItem mn;
        mn=navigationView.getMenu().getItem(1);
        mn.setChecked(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//     //   ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {
//
//            @Override
//            public void onDrawerClosed(View drawerView) {
//                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
//                super.onDrawerClosed(drawerView);
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank
//                super.onDrawerOpened(drawerView);
//            }
//        };

        //Setting the actionbarToggle to drawer layout
//        drawer.setDrawerListener(actionBarDrawerToggle);
//
//        //calling sync state is necessary or else your hamburger icon wont show up
//        actionBarDrawerToggle.syncState();
        // load nav menu header data


        // initializing navigation menu
        setUpNavigationView();
    }


    private void setUpNavigationView() {
        MenuItem mn;
        mn=navigationView.getMenu().getItem(2);
        mn.setChecked(true);
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:
                        navItemIndex = 0;
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        finish();
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_inter:
                        navItemIndex = 1;
                        startActivity(new Intent(getApplicationContext(), Inter_Activity.class));
                        drawer.closeDrawers();
                        return true;

                    case R.id.nav_intra:
                        navItemIndex = 2;
                        drawer.closeDrawers();
                        break;

                    case R.id.nav_place:
                        navItemIndex = 3;
                        startActivity(new Intent(getApplicationContext(), Places.class));
                        drawer.closeDrawers();
                        return  true;
                    case R.id.nav_developer:
                        navItemIndex = 4;
                        startActivity(new Intent(getApplicationContext(), Developer_Activity.class));
                        drawer.closeDrawers();
                        return  true;
                    case  R.id.nav_contacts:
                        startActivity(new Intent(getApplicationContext(), ContactAvtivity.class));
                        drawer.closeDrawers();
                        return  true;
                    case R.id.nav_rateus:
                        String url = "https://play.google.com/store/apps/details?id=com.mnnit.athleticmeet&hl=en";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_share:
                        try {
                            Intent i1 = new Intent(Intent.ACTION_SEND);
                            i1.setType("text/plain");
                            i1.putExtra(Intent.EXTRA_SUBJECT, "MAM2K18");
                            String sAux = "\nDownload the official Athletic Meet App(MAM2K18),MNNIT Allahabad \n\n";
                            sAux = sAux + "https://play.google.com/store/apps/details?id=com.mnnit.athleticmeet&hl=en \n\n";
                            i1.putExtra(Intent.EXTRA_TEXT, sAux);
                            startActivity(Intent.createChooser(i1, "choose one"));
                        } catch(Exception e) {
                            //e.toString();
                        }
                    case R.id.nav_about:
                        startActivity(new Intent(getApplicationContext(), About_Activity.class));
                        return true;

                    default:
                        navItemIndex = 0;
                }
                //Checking if the item is in checked state or not, if not make it in checked state

//                if (menuItem.isChecked()) {
//                    menuItem.setChecked(false);
//                } else {
//                    menuItem.setChecked(true);
//                }
                //menuItem.setChecked(true);


                return true;
            }
        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

